/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.Document;

/**
 *
 * @author 711541241
 */
public class MongoCollectionEfdUtil {

    public boolean isExisteNfePorCnpjChaveNfe(String numrCnpj, String chaveNfe, MongoCollection<Document> collectioEfd) {

        FindIterable<Document> doc = null;


        Document query = new Document();
        Document fields = new Document();

        fields.append("bloco0.registro0000.codVer", 1);                

        query.append("bloco0.registro0000.cnpj", numrCnpj);
        query.append("blocoC.registroC100.chvNfe", chaveNfe);        

        doc = collectioEfd.find(query).projection(fields);

        MongoCursor<Document> cursor = doc.iterator();

        while (cursor.hasNext()) {
            return true;
        }
        return false;

    }
    public Document consultarNfePorCnpjChaveNfe(String numrCnpj, String chaveNfe, MongoCollection<Document> collectioEfd) {

        FindIterable<Document> doc = null;


        Document query = new Document();
        Document fields = new Document();
        Document elemMatch = new Document();
        Document projection = new Document();        



        projection.append("blocoC.registroC100.chvNfe.$",1);
        query.append("bloco0.registro0000.cnpj", numrCnpj);
        query.append("blocoC.registroC100.chvNfe", chaveNfe);        
       
        doc = collectioEfd.find(query).projection(projection);


        MongoCursor<Document> cursor = doc.iterator();

        if (cursor.hasNext()) {
            return cursor.next();
        }
        return null;

    }    

    public boolean consultarNfePorChaveNatural(String numrCnpj, Integer NumDoc, String ser, MongoCollection<Document> collectioEfd) {

        FindIterable<Document> doc = null;

        doc = collectioEfd.find(Filters.and(Filters.eq("bloco0.registro0000.cnpj", numrCnpj), Filters.eq("blocoC.registroC100.NumDoc", NumDoc), Filters.eq("blocoC.registroC100.ser", ser)));

        MongoCursor<Document> cursor = doc.iterator();

        while (cursor.hasNext()) {
            Document document;
            //document = cursor.next();

            return true;

        }
        return false;

    }

    public List<String> consultarCnpj(MongoCollection<Document> collectioEfd) {

        FindIterable<Document> doc = null;

        doc = collectioEfd.find();
        MongoCursor<Document> cursor = doc.iterator();
        java.util.List<String> cnpjList = new ArrayList<>();
        int i = 0;
        while (cursor.hasNext()) {
            Document document;
            document = cursor.next();
            Document bloco0 = document.get("bloco0", Document.class);
            Document registro0000 = bloco0.get("registro0000", Document.class);
            String cnpj = registro0000.getString("cnpj");

            if (!cnpjList.contains(cnpj)) {
                cnpjList.add(cnpj);
            }
           


        }
        System.out.println("cnpjList:"+cnpjList.size());
        return cnpjList;
    }

    public Integer entregouEfd(String numrCnpj, MongoCollection<Document> collectioEfd) {

        FindIterable<Document> doc = null;
        long tempo = System.currentTimeMillis();
        doc = collectioEfd.find(Filters.eq("bloco0.registro0000.cnpj", numrCnpj));

        MongoCursor<Document> cursor = doc.iterator();
        Integer codVer = new Integer(0);
        if (cursor.hasNext()) {
            Document document;
            document = cursor.next();

            Document bloco0 = document.get("bloco0", Document.class);
            Document registro0000 = bloco0.get("registro0000", Document.class);
            codVer = registro0000.getInteger("codVer");
        }
        return codVer;

    }

    public boolean isConsultou(String numrCnpj, MongoCollection<Document> collectioEfd) {

        FindIterable<Document> doc = null;
        long tempo = System.currentTimeMillis();
        doc = collectioEfd.find(Filters.eq("bloco0.registro0000.cnpj", numrCnpj));

        MongoCursor<Document> cursor = doc.iterator();

        if (cursor.hasNext()) {
            return true;
        }
        return false;

    }

}
