/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.job;

import br.com.sped.scf.job.nfe.ThreadNfeValoresDivergentes;
import br.com.sped.scf.model.mongodb.MongoBanco;
import br.com.sped.scf.model.mongodb.MongoCollectionEfdUtil;
import br.com.sped.scf.model.repository.docdivergenciafiscal.DivergenciaDocFiscalRepository;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Service
public class DocumentosValoresDivergentesJob {

    @Autowired
    private DivergenciaDocFiscalRepository repository;
    
    
    @Scheduled(cron = "* * * * * *")
    public void verificarDivergenciaValoresDocumentoFiscal() {
        long tempo = System.currentTimeMillis();
        MongoBanco db = new MongoBanco(MongoBanco.URL_LOCAL);
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);
        MongoCollection<Document> collectioEfd = db.getCollectionEfd();
        MongoCollectionEfdUtil mongoCollectionEfdUtil = new MongoCollectionEfdUtil();

        try {

            java.util.List<String> cnpjList = mongoCollectionEfdUtil.consultarCnpj(collectioEfd);

            blockingQueue.put(new Integer(1));

            java.util.List<String> cnpjSubList = new ArrayList();
            for (int i = 0; i < cnpjList.size();  i++) {
                
                cnpjSubList.add(cnpjList.get(i));
                if(cnpjSubList.size()==50){
                    executorService(cnpjSubList, blockingQueue);
                    cnpjSubList.clear();
                }
            }
            if(cnpjSubList.size()>0){
                executorService(cnpjSubList, blockingQueue);  
                System.gc();
            }

        } catch (Exception e) {
             Logger.getLogger(DocumentosNaoEscrituradosJob.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("tempo Total:"+(System.currentTimeMillis()-tempo));
        System.exit(0);

    }
    public void executorService(java.util.List<String> cnpjList,BlockingQueue<Integer> blockingQueue ){
          ExecutorService   threadPoolExecutor = Executors.newFixedThreadPool(5);
          System.out.println("br.com.sped.scf.job.DocumentosNaoEscrituradosJob.executorService()");
          for (String cnpj : cnpjList){
            threadPoolExecutor.execute(new ThreadNfeValoresDivergentes(cnpj,blockingQueue,repository));
        }
        threadPoolExecutor.shutdown();
        
        while (!threadPoolExecutor.isTerminated()){
            try {
                System.out.println("cnpj:"+cnpjList.size() +" processado:" +blockingQueue.peek()+"Thread:" +Thread.currentThread().getId() + "threadPoolExecutor " +threadPoolExecutor.isTerminated());
                Thread.sleep(2000);

            } catch (Exception ex) {
                Logger.getLogger(DocumentosNaoEscrituradosJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        threadPoolExecutor = null;
    }


}

