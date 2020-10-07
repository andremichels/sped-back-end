/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author dario
 */
public class MongoCollectionNfeUtil {

    public List<Document> consultarNfePorCnpjDataEmissao(String numrCnpjmatriz, MongoCollection<Document> collectioNfe) {

        FindIterable<Document> doc = null;

        doc = collectioNfe.find(Filters.eq("numr_cnpj_cpf_emissor", numrCnpjmatriz));

        MongoCursor<Document> cursor = doc.iterator();
        java.util.List<Document> chv = new ArrayList<>();
        int i = 0;
        while (cursor.hasNext()) {
            Document document;
            document = cursor.next();
            chv.add(document);

        }
        System.out.println(numrCnpjmatriz + ":" + chv.size());
        return chv;
    }

    public Document consultarTagIdeandTotalNfePorChave(String chaveNfe, MongoCollection<Document> collectioNfe) {

        FindIterable<Document> doc = null;

        Document query = new Document();
        Document fields = new Document();

        fields.append("NFe.infNFe.ide", 1);
        fields.append("NFe.infNFe.total.ICMSTot", 1);
        query.append("chave", chaveNfe);

        doc = collectioNfe.find(query).projection(fields);

        MongoCursor<Document> cursor = doc.iterator();

        if (cursor.hasNext()) {
            return cursor.next();
        }
        return null;

    }

    public List<String> consultarNfePorCnpj(String numrCnpjmatriz, MongoCollection<Document> collectioNfe) {

        FindIterable<Document> doc = null;

        doc = collectioNfe.find(Filters.eq("numr_cnpj_cpf_emissor", numrCnpjmatriz));

        MongoCursor<Document> cursor = doc.iterator();
        java.util.List<String> chv = new ArrayList<>();
        while (cursor.hasNext()) {
            Document document;
            document = cursor.next();
            String chaveNfe = document.getString("chave");
            chv.add(chaveNfe);
        }
       // System.out.println(numrCnpjmatriz + ":" + chv.size());
        return chv;
    }

    public List<String> consultarCnpj(MongoCollection<Document> collectioNfe) {

        FindIterable<Document> doc = null;

        doc = collectioNfe.find(Filters.and(Filters.eq("NFe.infNFe.emit.CNPJ", "00025238000171"), Filters.eq("NFe.infNFe.ide.dEmi", "2020-06-25 15:17:08")));

        MongoCursor<Document> cursor = doc.iterator();
        java.util.List<String> cnpjList = new ArrayList<>();
        int i = 0;
        while (cursor.hasNext()) {
            Document document;
            document = cursor.next();
            String cnpj = document.get("numr_cnpj_cpf_emissor").toString();
            if (!cnpjList.contains(cnpj)) {
                cnpjList.add(cnpj);
            }
            //   System.out.println("i:"+i++);

        }

        return cnpjList;
    }

    public Document consultarNfePorChave(String chave, MongoCollection<Document> collectioNfe) {

        FindIterable<Document> doc = null;

        doc = collectioNfe.find(Filters.eq("chave", chave));

        MongoCursor<Document> cursor = doc.iterator();

        if (cursor.hasNext()) {

            return cursor.next();

        }
        return null;
    }
}
