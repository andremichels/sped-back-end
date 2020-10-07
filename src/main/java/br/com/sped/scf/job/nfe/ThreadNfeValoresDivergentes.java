/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.job.nfe;

import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import br.com.sped.scf.model.entity.efd.blococ.BlocoC;
import br.com.sped.scf.model.entity.nfe.ICMSTot;
import br.com.sped.scf.model.mongodb.MongoBanco;
import br.com.sped.scf.model.mongodb.MongoCollectionEfdUtil;
import br.com.sped.scf.model.mongodb.MongoCollectionNfeUtil;
import br.com.sped.scf.model.repository.docdivergenciafiscal.DivergenciaDocFiscalRepository;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 711541241
 */
public class ThreadNfeValoresDivergentes extends Thread {

    private String cnpj;
    MongoBanco db;
    private BlockingQueue<Integer> blockingQueue;

    private MongoCollectionEfdUtil mongoCollectionEfdUtil;
    private MongoCollectionNfeUtil mongoCollectionNfeUtil;
    private MongoCollection<Document> collectioNfe;
    private MongoCollection<Document> collectioEfd;
    private MongoCollection<Document> collectioDivergenciaDocFiscal;
    
    private DivergenciaDocFiscalRepository repository;

    
    public ThreadNfeValoresDivergentes(String cnpj,BlockingQueue<Integer> blockingQueues,DivergenciaDocFiscalRepository repository) {
        this.cnpj = cnpj;
        this.blockingQueue = blockingQueues;
        this.repository = repository;
    }

    @Override
    public void run() {
        try {
          //  System.out.println("br.com.sped.scf.job.nfe.ThreadNfeValoresDivergentes.run()"+this.getId());
            iniciarCollectionMongoDb();
            verificarValorIcmsValorNotaFiscal();
            finalizarCollectionMongoDb();
            Integer quantidade = blockingQueue.take();
            int add = quantidade +1;
            blockingQueue.put(new Integer(add));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void teste2() {
           iniciarCollectionMongoDb();
           verificarValorIcmsValorNotaFiscal();
           finalizarCollectionMongoDb();
    }
    
 

    private void verificarValorIcmsValorNotaFiscal() {

        List<String> chaveNfeList = mongoCollectionNfeUtil.consultarNfePorCnpj(cnpj, collectioNfe);
        System.out.println("cnpj:"+cnpj+ " chaveNfeList:"+chaveNfeList.size());
        Gson g = new Gson();
        for (String chave : chaveNfeList) {

            String numr_cnpj_cpf_emissor = String.valueOf(new Long(cnpj));

            Document docNfeEfd = mongoCollectionEfdUtil.consultarNfePorCnpjChaveNfe(numr_cnpj_cpf_emissor, chave, collectioEfd);


            if (docNfeEfd != null) {

                try {
                    BlocoC blocoC = g.fromJson(docNfeEfd.get("blocoC", Document.class).toJson(), BlocoC.class);

                    Document docNfe = mongoCollectionNfeUtil.consultarTagIdeandTotalNfePorChave(chave, collectioNfe);

                    Document ICMSTotDocument = docNfe.get("NFe", Document.class).get("infNFe", Document.class).get("total", Document.class).get("ICMSTot", Document.class);

                    ICMSTot iCMSTot = g.fromJson(ICMSTotDocument.toJson(), ICMSTot.class);

                    boolean isValorDocOK = valorNotaFiscalOk(blocoC, iCMSTot);
                    boolean isIcmsOK = valorIcmsOK(blocoC, iCMSTot);
                    boolean isIcmsStOK = valorIcmsStOk(blocoC, iCMSTot);

                    if (!isValorDocOK || !isValorDocOK || !isValorDocOK) {
                        gravarDivergenciaDocFiscal1(chave, cnpj, iCMSTot, blocoC, !isValorDocOK, !isIcmsOK, !isIcmsStOK);
                    }
                    docNfeEfd = null;
                    docNfe = null;
                } catch (Exception e) {
                    System.out.println(chave);
                    e.printStackTrace();
                }
            }

        }
        if(chaveNfeList != null)
            chaveNfeList.clear();
        chaveNfeList = null;
    }

    private boolean valorNotaFiscalOk(BlocoC blocoC, ICMSTot iCMSTot) {
        double aprox = 10d;
        BigDecimal vlDoc = blocoC.firstRegistroC100().getVlDoc();
        BigDecimal vNF = new BigDecimal(iCMSTot.getvNF());
        if (vlDoc == null) {
            return false;
        }
        double valorDoc = vlDoc.doubleValue();

        double valorNf = vNF.doubleValue();
        if ((valorNf > (valorDoc - aprox)) && (valorNf < (valorDoc + aprox))) {
            return true;
        }

        return false;
    }

    private boolean valorIcmsOK(BlocoC blocoC, ICMSTot iCMSTot) {
        double aprox = 5d;
        BigDecimal vlIcms = blocoC.firstRegistroC100().getVlIcms();
        if(vlIcms == null)
            return false;
        BigDecimal vIcmsNF = new BigDecimal(iCMSTot.getvICMS());

        return (vlIcms.doubleValue() > (vIcmsNF.doubleValue() - aprox)) && (vlIcms.doubleValue() < (vIcmsNF.doubleValue() + aprox));
    }

    private boolean valorIcmsStOk(BlocoC blocoC, ICMSTot iCMSTot) {
        if(iCMSTot.getvST() == null)
            return true;

        BigDecimal vIcmsStNF = new BigDecimal(iCMSTot.getvST());
        if(vIcmsStNF.doubleValue() == 0)
            return true;
        
        double aprox = 5d;
        BigDecimal vlIcms = blocoC.firstRegistroC100().getVlIcmsSt();

        if(vlIcms == null)
            return false;
        


        return (vlIcms.doubleValue() > (vIcmsStNF.doubleValue() - aprox)) && (vlIcms.doubleValue() < (vIcmsStNF.doubleValue() + aprox));
    }

    private void gravarDivergenciaDocFiscal1(String chaveNfe, String cnpjEmissor, ICMSTot iCMSTot, BlocoC blocoC, boolean divergenciaValorNfe, boolean divergenciaValorIcms, boolean divergenciaImcsSt ) {


        DivergenciaDocFiscal divergenciaDocFiscal = new DivergenciaDocFiscal();
        divergenciaDocFiscal.setChaveDoc(chaveNfe);
        divergenciaDocFiscal.setCnpjEmissor(cnpjEmissor);

        if (divergenciaValorNfe) {
            divergenciaDocFiscal.setValorEfd(blocoC.firstRegistroC100().getVlDoc());
            divergenciaDocFiscal.setValorDoc(new BigDecimal(iCMSTot.getvNF()));
        }
        if (divergenciaValorIcms) {
            divergenciaDocFiscal.setValorEfdImcs(blocoC.firstRegistroC100().getVlIcms());
            divergenciaDocFiscal.setValorDocImcs(new BigDecimal(iCMSTot.getvICMS()));
        }
        if (divergenciaImcsSt) {
            divergenciaDocFiscal.setValorEfdImcsSt(blocoC.firstRegistroC100().getVlIcmsSt());
            divergenciaDocFiscal.setValorDocImcsSt(new BigDecimal(iCMSTot.getvST()));
        }
        repository.save(divergenciaDocFiscal);

    }

    private void gravarDivergenciaDocFiscal(String chaveNfe, String cnpjEmissor, ICMSTot iCMSTot, BlocoC blocoC, boolean divergenciaValorNfe, boolean divergenciaValorIcms, boolean divergenciaImcsSt ) {


        Document doc = new Document();
        doc.put("chaveNfe", chaveNfe);
        doc.put("cnpjEmissor", cnpjEmissor);

        if (divergenciaValorNfe) {
            doc.put("valorEfd", blocoC.firstRegistroC100().getVlDoc());
            doc.put("valorDoc", new BigDecimal(iCMSTot.getvNF()));
        }
        if (divergenciaValorIcms) {
            doc.put("valorEfdImcs", blocoC.firstRegistroC100().getVlIcms());
            doc.put("valorDocImcs", new BigDecimal(iCMSTot.getvICMS()));
        }
        if (divergenciaImcsSt) {
            doc.put("valorEfdImcsSt", blocoC.firstRegistroC100().getVlIcmsSt());
            doc.put("valorDocImcsSt", new BigDecimal(iCMSTot.getvST()));

        }

        collectioDivergenciaDocFiscal.insertOne(doc);
    }

    private void iniciarCollectionMongoDb() {
        db = new MongoBanco(MongoBanco.URL_LOCAL);

        collectioNfe = db.getCollectionNfe();
        collectioEfd = db.getCollectionEfd();
        collectioDivergenciaDocFiscal = db.getCollectionDivergenciaDocFiscal();
        mongoCollectionEfdUtil = new MongoCollectionEfdUtil();
        mongoCollectionNfeUtil = new MongoCollectionNfeUtil();

    }
    private void finalizarCollectionMongoDb() {
        db.close();

        collectioNfe = null;
        collectioEfd = null;
        collectioDivergenciaDocFiscal = null;
        mongoCollectionEfdUtil = null;
        mongoCollectionNfeUtil = null;

    }
    

}
