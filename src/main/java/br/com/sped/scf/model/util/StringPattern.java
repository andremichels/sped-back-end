/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPattern {

    public StringPattern() {
    }

    public static String obterStringPorPattern(String pattern, String xml) {
        String retorno = null;
        Pattern pat = null;
        Matcher mat = null;
//      xml = xml.replaceAll("", "").replaceAll("\r", "").replaceAll("\n","");;
        try {
            pat = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            mat = pat.matcher(xml);

            if (mat.find()) {
                if ((xml.length() - 1) != mat.end() && (xml.substring(mat.end(), mat.end() + 1).equals(",") || xml.substring(mat.end(), mat.end() + 1).matches("[0-9]"))) {
                    return null;
                }

                retorno = xml.substring(mat.start(), mat.end());

            }
        } finally {
            pat = null;
            mat = null;
        }
        return retorno;
    }
/*
    public static void obterListPgdas(String pathArquivo, Collection<String> collMunicipios, LinkedBlockingQueue<Pgdasd> linkedBlockingQueuePgdasdArquivo) throws IOException {

        Collection<String> collMunicipioAux = new ArrayList<>();

        for (String codgMunicipio : collMunicipios) {
            collMunicipioAux.add("(\\|" + codgMunicipio + ")");
        }

        Pattern pattern = Pattern.compile("^00000|.*?\\r\\n99999|\\d[0-9]{2}?", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));
        int cont = 0;
        while (leitor.findWithinHorizon(pattern, 0) != null) {

            String pgdas = leitor.match().group(0);
            ExecutorService threadpool = Executors.newFixedThreadPool(200);
            CompletionService<Boolean> threadCompletion = new ExecutorCompletionService(threadpool);
            for (String municipio : collMunicipioAux) {
                threadCompletion.submit(new StringPatternCallable(pgdas, municipio));
            }
            for (int i = 0; i < collMunicipioAux.size(); i++) {

                try {
                    if (threadCompletion.take().get()) {
                        Pgdasd pgdasd = new Pgdasd(pgdas);
                        pgdasd.executar();
                        if (pgdasd.getPgdasdRegistro00000() != null) {
                            linkedBlockingQueuePgdasdArquivo.put(pgdasd);
                        } else {
                            System.err.println(pgdas);
                        }
                        break;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(StringPattern.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            threadpool.shutdown();

        }

    }

    public static void obterListPgdas(String pathArquivo, LinkedBlockingQueue<Pgdasd> linkedBlockingQueuePgdasdArquivo) throws IOException {

        Pattern pattern = Pattern.compile("^00000|.*?\\r\\n99999|\\d[0-9]{2}?", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));
        while (leitor.findWithinHorizon(pattern, 0) != null) {

            String pgdas = leitor.match().group(0);
            Pgdasd pgdasd = new Pgdasd(pgdas);
            pgdasd.executar();
            if (pgdasd.getPgdasdRegistro00000() == null) {
                continue;
            }

            

            try {
                linkedBlockingQueuePgdasdArquivo.put(pgdasd);
            } catch (InterruptedException ex) {
                Logger.getLogger(StringPattern.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void obterListPgdas(String pathArquivo, LinkedBlockingQueue<Pgdasd> linkedBlockingQueuePgdasdArquivo, TreeSet<Long> treeSetCnpj) throws IOException {

        Pattern pattern = Pattern.compile("^00000|.*?\\r\\n99999|\\d[0-9]{2}?", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));
        long cont = 0;
        while (true) {

            //long tempo = System.currentTimeMillis();
            if (leitor.findWithinHorizon(pattern, 0) == null) {
                break;
            }

            String pgdas = leitor.match().group(0);
            Pgdasd pgdasd = new Pgdasd(pgdas);
            pgdasd.executar();

            try {

                if (pgdasd.getPgdasdRegistro00000() != null && treeSetCnpj.contains(pgdasd.getPgdasdRegistro00000().getContribuinteVo().getCnpjContribuinte())) {
                    linkedBlockingQueuePgdasdArquivo.put(pgdasd);
                    pgdasd = null;
                    System.out.println(cont);

                    System.out.println("linkedBlockingQueuePgdasdArquivo" + linkedBlockingQueuePgdasdArquivo.size());
                }
                pgdasd = null;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(pgdas);
            }
            cont++;

            pgdas = null;
        }
    }

    public static List<String> getListStringPatterner(String pattern, String xml, Collection<String> collMunicipios) {
        Pattern pat = null;
        Matcher mat = null;
        int posicao = 0;
        List<String> ret = new ArrayList<>();
        try {
            //xml = xml.replaceAll("\r","").replaceAll("\n","");
            pat = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            mat = pat.matcher(xml);

            while (mat.find(posicao)) {

                String textoRet = xml.substring(mat.start(), mat.end());
                for (String codgMunicipio : collMunicipios) {
                    if (StringPattern.obterStringPorPattern(codgMunicipio, textoRet) != null) {
                        ret.add(textoRet);
                    }
                }

                posicao = mat.end();
            }

            return ret.size() > 0 ? ret : null;
        } finally {
            pat = null;
            mat = null;
        }
    }
*/
}
