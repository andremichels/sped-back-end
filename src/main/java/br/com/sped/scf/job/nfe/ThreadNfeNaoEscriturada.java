/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.job.nfe;

import br.com.sped.scf.model.enums.TipoNotaFiscal;
import br.com.sped.scf.model.mongodb.MongoBanco;
import br.com.sped.scf.model.mongodb.MongoCollectionEfdUtil;
import br.com.sped.scf.model.mongodb.MongoCollectionNfeUtil;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.List;

/**
 *
 * @author 711541241
 */
public class ThreadNfeNaoEscriturada extends Thread {

    private String cnpj;
    MongoBanco db;
    private MongoCollectionEfdUtil mongoCollectionEfdUtil;
    private MongoCollectionNfeUtil mongoCollectionNfeUtil;
    private MongoCollection<Document> collectioNfe;
    private MongoCollection<Document> collectioEfd;
    private MongoCollection<Document> collectioNfeNaoEscriturada;

    public ThreadNfeNaoEscriturada(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void run() {
        try {
           iniciarCollectionMongoDb();            
            verificarNfeEscrituracao();
            finalizarCollectionMongoDb();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void finalizarCollectionMongoDb() {
        db.close();
        collectioNfe = null;
        collectioEfd =null;
        collectioNfeNaoEscriturada =null;
        mongoCollectionEfdUtil= null;
        mongoCollectionNfeUtil= null;

    }
    
    private void verificarNfeEscrituracao() {

        List<String> chaveNfeList = mongoCollectionNfeUtil.consultarNfePorCnpj(cnpj, collectioNfe);
        
        for (String chave : chaveNfeList) {
            String numr_cnpj_cpf_emissor = String.valueOf(new Long(cnpj));
            //long tempo = System.currentTimeMillis();
            boolean isEfd = mongoCollectionEfdUtil.isExisteNfePorCnpjChaveNfe(numr_cnpj_cpf_emissor, chave, collectioEfd);
            if(!isEfd)
                gravarNfeNaoEscriturada(chave, cnpj);
           // System.out.println("tempo:"+(System.currentTimeMillis()-tempo));

        }
    }

    private void gravarNfeNaoEscriturada(String chave, String cnpj) {
        Document nfe = mongoCollectionNfeUtil.consultarNfePorChave(chave, collectioNfe);

        Document nf = nfe.get("NFe", Document.class);
        Document infNFe = nf.get("infNFe", Document.class);
        Document ide = infNFe.get("ide", Document.class);
        Document total = infNFe.get("total", Document.class);
        Document ICMSTot = total.get("ICMSTot", Document.class);

        Integer nNF = ide.getInteger("nNF");
        Integer serie = ide.getInteger("serie");
        Integer tpNF = ide.getInteger("tpNF");
        TipoNotaFiscal tipoNotaFiscal = TipoNotaFiscal.of(tpNF);
        boolean encontrou = mongoCollectionEfdUtil.consultarNfePorChaveNatural(cnpj, nNF, String.valueOf(serie), collectioEfd);

        Integer numrEfd = mongoCollectionEfdUtil.entregouEfd(cnpj, collectioEfd);
        Document nfeNaoEscriturada = new Document();
        nfeNaoEscriturada.append("chaveNfe", chave);
        nfeNaoEscriturada.append("numrEfd", numrEfd);
        nfeNaoEscriturada.append("tpNF", tipoNotaFiscal.getDescricao());
        Object vNF = ICMSTot.get("vNF");
        Object vICMS = ICMSTot.get("vICMS");

        nfeNaoEscriturada.append("vNF", vNF);
        nfeNaoEscriturada.append("vICMS", vICMS);
        nfeNaoEscriturada.append("numr_cnpj_cpf_emissor", cnpj);
        nfeNaoEscriturada.append("esrituradaChaveNatural", encontrou);
        collectioNfeNaoEscriturada.insertOne(nfeNaoEscriturada);
        System.out.println(chave + " numrEfd:" + numrEfd + " chave natural: " + encontrou);

    }

    private void iniciarCollectionMongoDb() {
        db = new MongoBanco(MongoBanco.URL_LOCAL);

        collectioNfe = db.getCollectionNfe();
        collectioEfd = db.getCollectionEfd();
        collectioNfeNaoEscriturada = db.getCollectionNfeNaoEscriturada();
        mongoCollectionEfdUtil = new MongoCollectionEfdUtil();
        mongoCollectionNfeUtil = new MongoCollectionNfeUtil();

    }

}
