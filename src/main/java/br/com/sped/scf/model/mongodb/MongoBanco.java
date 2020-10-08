package br.com.sped.scf.model.mongodb;

import br.com.sped.scf.model.enums.NomeCollectionMongoDb;
import ch.qos.logback.classic.LoggerContext;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import org.slf4j.LoggerFactory;

public class MongoBanco {

    private MongoDatabase database;

    private MongoClient mongoClient;
    private String url;
    public static String URL_LOCAL ="mongodb://localhost:27017";
    public static String URL_REMOTO ="mongodb+srv://spin-java-apps:ZI46QrIguIFMM3jn@cluster0.bgzlo.gcp.mongodb.net/SPED?retryWrites=true&w=majority";    
    static {

        //root.setLevel(Level.INFO); 
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(ch.qos.logback.classic.Level.OFF);

    }
    public MongoBanco(String url){
        this.url = url;
    }
    public void close() {
        try {

            mongoClient.close();
            database = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MongoDatabase getBancoSPED() {
        try {

            mongoClient = MongoClients.create(url);

            database = mongoClient.getDatabase("SPED");

            return database;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
/*
    public MongoDatabase getBancoRemotoSPED() {
        try {

            mongoClient = MongoClients.create("mongodb+srv://spin-java-apps:ZI46QrIguIFMM3jn@cluster0.bgzlo.gcp.mongodb.net/SPED?retryWrites=true&w=majority");

            database = mongoClient.getDatabase("SPED");

            return database;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/
    
    public MongoCollection<Document> getCollectionDivergenciaDocFiscal() {
        try {

            if(database == null )
                database = getBancoSPED();
            MongoCollection<Document> collectioDivergenciaNfe = database.getCollection(NomeCollectionMongoDb.DIVERGENCIA_NFE_COLLECTION.getDescricao());

            return collectioDivergenciaNfe;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  public MongoCollection<Document> getCollectionDivergenciaDocFiscalTeste() {
        try {

            if(database == null )
                database = getBancoSPED();
            MongoCollection<Document> collectioDivergenciaNfe = database.getCollection("DivergenciaDocFiscalTeste");

            return collectioDivergenciaNfe;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
    public MongoCollection<Document> getCollectionEfd() {
        try {

            if(database == null )
                database = getBancoSPED();

            MongoCollection<Document> collectioEfd = database.getCollection(NomeCollectionMongoDb.EFD_COLLECTION.getDescricao());

            return collectioEfd;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MongoCollection<Document> getCollectionNfe() {
        try {

            if(database == null )
                database = getBancoSPED();

            MongoCollection<Document> collectioEfd = database.getCollection(NomeCollectionMongoDb.NFE_COLLECTION.getDescricao());

            return collectioEfd;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MongoCollection<Document> getCollectionNfeNaoEscriturada() {
        try {

            if(database == null )
                database = getBancoSPED();

            MongoCollection<Document> collectioEfd = database.getCollection(NomeCollectionMongoDb.NFE_NAO_ESCRITURADA_COLLECTION.getDescricao());

            return collectioEfd;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MongoBanco pr = new MongoBanco(MongoBanco.URL_LOCAL);
        pr.getBancoSPED();
        System.out.println(pr.getCollectionNfe().countDocuments()); ;

        try {
                    Thread.sleep(10000);
        } catch (Exception e) {
        }

        

    }

}
