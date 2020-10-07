/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util.efd;

import br.com.sped.scf.model.mongodb.MongoBanco;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
public class ReadFileCteUtil {
    int i = 0;
    String diretorio;
    static Gson gson;
    MongoDatabase mongoDatabase;
    private MongoCollection<Document> collectioCte;
    private List<File> nomeArquivo;

    public ReadFileCteUtil(String diretorio) {
        this.diretorio = diretorio;
        nomeArquivo = new ArrayList<>();
        MongoBanco db = new MongoBanco(MongoBanco.URL_REMOTO);
        mongoDatabase = db.getBancoSPED();
        collectioCte = mongoDatabase.getCollection("Cte");
                System.out.println(collectioCte.countDocuments()); 
        gson = new Gson();

    }

    public void lerArquivos() {
        File file = new File(diretorio);
        listFilesForFolder(file);

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
            collectioCte.insertOne(doc);
            if(i>10000)
                System.exit(0);
            
            System.out.println(i++);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    public String lerArquivoNfe(String pathAr) {
        Scanner leitor = null;
        try {
            leitor = new Scanner(Paths.get(pathAr));
        } catch (IOException ex) {
            Logger.getLogger(ReadFileNfeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        Pattern pattern = Pattern.compile("<CTe.*?</CTe>", Pattern.DOTALL);

        while (leitor.findWithinHorizon(pattern, 0) != null) {
            String xml = leitor.match().group(0);
            gravarBanco(xml);
            return xml;
        }
        return null;
    }

    public static void main(String[] args) {
        ReadFileCteUtil readFileCteUtil = new ReadFileCteUtil("D:\\SPED\\docFiscal\\cte_gerados");
        readFileCteUtil.lerArquivos();

    }    
}
