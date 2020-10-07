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
import org.bson.Document;

/**
 *
 * @author dario
 */
public class MongoCollectionCteUtil {

    public long consultarNfePorCnpjDataEmissao(String numrCnpj, String dEmi,MongoCollection<Document> collectioCte) {

        FindIterable<Document> doc = null;

        doc = collectioCte.find(Filters.and(Filters.eq("NFe.infNFe.emit.CNPJ", "00025238000171"),Filters.eq("NFe.infNFe.ide.dEmi", "2020-06-25 15:17:08")));
        MongoCursor<Document> cursor = doc.iterator();
        while (cursor.hasNext()) {
            Document document;
            document = cursor.next();
            System.out.println(document.toJson());

        }

        return 0;
    }
    
}
