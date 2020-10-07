/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.job;

import br.com.sped.scf.model.mongodb.MongoBanco;
import br.com.sped.scf.model.util.GeradorCnpj;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import org.bson.conversions.Bson;

/**
 *
 * @author dario
 */
public class CargaMongoGc {

    private HashMap<String, String> cnpj;

    public static void main(String[] args) {
        CargaMongoGc cargaMongoGc = new CargaMongoGc();
        cargaMongoGc.alterar();

    }


    private void carga() {
        cnpj = new HashMap();
        MongoBanco dbLocal = new MongoBanco(MongoBanco.URL_LOCAL);
        MongoBanco dbRemoto = new MongoBanco(MongoBanco.URL_REMOTO);
        MongoCollection<Document> collectioDivergenciaLocal = dbLocal.getCollectionDivergenciaDocFiscal();
        MongoCollection<Document> collectioDivergenciaLocalTeste = dbRemoto.getCollectionDivergenciaDocFiscal();
        FindIterable<Document> doc = null;

        doc = collectioDivergenciaLocal.find();

        MongoCursor<Document> cursor = doc.iterator();

        while (cursor.hasNext()) {

            Document document = cursor.next();
            String cnpjEmissor = document.getString("cnpjEmissor");
            String chaveNfe = document.getString("chaveNfe");

            if (!cnpj.containsKey(cnpjEmissor)) {
                cnpj.put(cnpjEmissor, GeradorCnpj.geraCNPJ());
            }
            //System.out.println("++++++++++++++");
            //System.out.println(cnpjEmissor);
            //System.out.println(chaveNfe);            
            //System.out.println(novaChaveNfe);

        }

        for (Map.Entry<String, String> entry : cnpj.entrySet()) {
            String cnpj = (String) entry.getKey();
            String novoCnpj = String.valueOf(Long.parseLong((String) entry.getValue()));
            doc = collectioDivergenciaLocal.find(Filters.eq("cnpjEmissor", cnpj));

            MongoCursor<Document> cursor1 = doc.iterator();
            while (cursor1.hasNext()) {
                Document docAux = cursor1.next();
                String chaveNfe = docAux.getString("chaveNfe");
                String novaChaveNfe = chaveNfe.substring(0, 6) + novoCnpj + chaveNfe.substring(20, 44);

                docAux.remove("chaveNfe");
                docAux.put("cnpjEmissor", novoCnpj);
                docAux.append("chaveDoc", novaChaveNfe);
                docAux.append("anoMes", Integer.valueOf(202007));
                docAux.append("tipoDoc", "Nfe");
                collectioDivergenciaLocalTeste.insertOne(docAux);
            }

//            System.out.println("cnpj:" + entry.getKey() + "novo cnpj:" + entry.getValue());
        }

        //MongoCollection<Document> collectioDivergenciaGc = db.getCollectionDivergenciaDocFiscalGc();
    }

    private void alterar() {
        cnpj = new HashMap();
        MongoBanco dbLocal = new MongoBanco(MongoBanco.URL_LOCAL);
        MongoBanco dbRemoto = new MongoBanco(MongoBanco.URL_LOCAL);
        MongoCollection<Document> collectioDivergenciaLocal = dbLocal.getCollectionDivergenciaDocFiscal();
        MongoCollection<Document> collectioDivergenciaLocalTeste = dbRemoto.getCollectionDivergenciaDocFiscal();
        FindIterable<Document> doc = null;

         Bson filter = eq("cnpjEmissor", "57240001870");  
        doc = collectioDivergenciaLocal.find(filter);

        MongoCursor<Document> cursor = doc.iterator();

        while (cursor.hasNext()) {

            Document document = cursor.next();
            
            
            document.append("anoMes", Integer.valueOf(202007));

            collectioDivergenciaLocal.updateOne(document,filter);
            System.exit(0);
            

        }


        //MongoCollection<Document> collectioDivergenciaGc = db.getCollectionDivergenciaDocFiscalGc();
    }    
    
}
