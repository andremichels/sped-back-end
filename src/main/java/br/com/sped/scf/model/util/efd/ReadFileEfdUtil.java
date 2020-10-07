package br.com.sped.scf.model.util.efd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.sped.scf.model.entity.efd.Efd;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD100;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD101;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD190;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD197;
import br.com.sped.scf.model.mongodb.MongoBanco;
import br.com.sped.scf.model.util.ConvertToJsonUtil;
import br.com.sped.scf.model.util.ReadLineUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.text.ParseException;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author dario
 */
public class ReadFileEfdUtil {

    ReadBloco0Util readFileBloco0Util;
    ReadBlocoCUtil readBlocoCUtil;
    ReadBlocoDUtil readBlocoDUtil;
    ReadBlocoEUtil readBlocoEUtil;
    String nomeArquivo;
    Efd efd;
    MongoDatabase mongoDatabase;
    private MongoCollection<Document> collectionEfd;

    public ReadFileEfdUtil(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        efd = new Efd();
        readFileBloco0Util = new ReadBloco0Util();
        readBlocoCUtil = new ReadBlocoCUtil();
        readBlocoDUtil = new ReadBlocoDUtil();
        readBlocoEUtil = new ReadBlocoEUtil();
        MongoBanco db = new MongoBanco(MongoBanco.URL_LOCAL);
        mongoDatabase = db.getBancoSPED();

        collectionEfd = mongoDatabase.getCollection("Efd");
    }

    public static void main(String[] args) {
        ReadFileEfdUtil readFileEfdUtil = new ReadFileEfdUtil("C:\\PROJETOS\\SPED\\F0905293_SRF+SRF1_EFD_003-9951-SpedEFD-10953876000106-133745287-1-202002-15072020151246-014-15072020153842.txt");
        readFileEfdUtil.lerArquivo();
    }

    public void lerArquivo() {

        try {
            List<String[]> bloco0List = RegexBlocosEfdUtil.obterBloco0(nomeArquivo);
            readFileBloco0Util.processarBloco0(bloco0List,efd);

            List<String[]> blocoCList = RegexBlocosEfdUtil.obterBlocoC(nomeArquivo);
            readBlocoCUtil.processarBlocoC(blocoCList, efd);

            List<String[]> blocoDList = RegexBlocosEfdUtil.obterBlocoD(nomeArquivo);

            readBlocoDUtil.processarBlocoD(blocoDList, efd);
           
            List<String[]> blocoEList = RegexBlocosEfdUtil.obterBlocoE(nomeArquivo);
            readBlocoEUtil.processarBlocoE(blocoEList, efd);

            
            criarEfd();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void criarEfd() {

        String jsonEfd = ConvertToJsonUtil.converterObjeto(efd);
       Document docEfd = Document.parse(jsonEfd);
       collectionEfd.insertOne(docEfd);
       System.out.println(jsonEfd);

    }

   

}
