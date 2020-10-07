/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util.efd;

import br.com.sped.scf.model.mongodb.MongoBanco;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 *
 * @author dario
 */
public class ReadFileNfeUtil {
    int cont=0;
    String diretorio;
    static Gson gson;
    MongoDatabase mongoDatabase;
    private MongoCollection<Document> collectioNfe;
    private List<File> nomeArquivo;

    public ReadFileNfeUtil(String diretorio) {
        this.diretorio = diretorio;
        nomeArquivo = new ArrayList<>();
        MongoBanco db = new MongoBanco(MongoBanco.URL_REMOTO);


        collectioNfe = db.getCollectionNfe();
        collectioNfe.drop();
        System.out.println(collectioNfe.countDocuments()); 
        collectioNfe = db.getCollectionNfe();
        System.out.println(collectioNfe.countDocuments());         
        gson = new Gson();

    }

    public void lerArquivos() {
        File file = new File(diretorio);
        listFilesForFolder(file);
        for (File file1 : nomeArquivo) {
            lerArquivoNfe(file1.getAbsolutePath());
        }

    }

    private void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                //System.out.println(fileEntry.getName());
                lerArquivoNfe(fileEntry.getAbsolutePath());
                // nomeArquivo.add(fileEntry);

            }
        }
    }

    private void gravarBanco(String xml) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node = xmlMapper.readTree(xml.getBytes());
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writeValueAsString(node);

            Document doc = Document.parse(json);
            collectioNfe.insertOne(doc);
            if(cont>10000)
                System.exit(0);
            System.out.println(cont++);

        } catch (Exception e) {
        // e.printStackTrace();
        }

    }

    public String lerArquivoNfe(String pathAr) {
        Scanner leitor = null;
        try {
            leitor = new Scanner(Paths.get(pathAr));
        } catch (IOException ex) {
            Logger.getLogger(ReadFileNfeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        Pattern pattern = Pattern.compile("<nfeProc.*?nfeProc>", Pattern.DOTALL);

        while (leitor.findWithinHorizon(pattern, 0) != null) {
            String xmlnfe = leitor.match().group(0);
            gravarBanco(xmlnfe);
            return xmlnfe;
        }
        return null;
    }

    public static void main(String[] args) {
        ReadFileNfeUtil readFileNfeUtil = new ReadFileNfeUtil("D:\\SPED\\docFiscal\\nfe_geradas");
        readFileNfeUtil.lerArquivos();

    }

}
