/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util.efd;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author dario
 */
public class RegexBlocosEfdUtil {

    public static List<String[]> obterBloco0(String pathArquivo) throws IOException {

        Pattern pattern = Pattern.compile("0000.*?0990", Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));

        if (leitor.findWithinHorizon(pattern, 0) != null) {
            String bloco = leitor.match().group(0);
            return converterEmLinha(bloco);

        }
        return null;
    }

    public static List<String[]> obterBlocoC(String pathArquivo) throws IOException {

        Pattern pattern = Pattern.compile("C001.*?C990", Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));

        if (leitor.findWithinHorizon(pattern, 0) != null) {
            String bloco = leitor.match().group(0);
            return converterEmLinha(bloco);

        }
        return null;
    }

    public static List<String[]> obterBlocoE(String pathArquivo) throws IOException {

        Pattern pattern = Pattern.compile("E001.*?E990", Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));

        if (leitor.findWithinHorizon(pattern, 0) != null) {
            String bloco = leitor.match().group(0);
            return converterEmLinha(bloco);

        }
        return null;
    }
    
    public static List<String[]> obterBlocoD(String pathArquivo) throws IOException {

        Pattern pattern = Pattern.compile("D001.*?D990", Pattern.DOTALL);

        Scanner leitor = new Scanner(Paths.get(pathArquivo));

        if (leitor.findWithinHorizon(pattern, 0) != null) {
            String bloco = leitor.match().group(0);
            return converterEmLinha(bloco);

        }
        return null;
    }    

    private static List<String[]> converterEmLinha(String bloco) {
        String res[] = bloco.split("\\r");
        List<String[]> linhas = new ArrayList();
        for (String re : res) {
            String[] linha = re.split("\\|");
            if (linha.length > 0 && linha[0].length() == 1) {
                linha = Arrays.copyOfRange(linha, 1, (linha.length - 1));
            }
            linhas.add(linha);
        }
        return linhas;
    }

    public static void main(String[] args) {
        RegexBlocosEfdUtil encontrarBlocosEfdUtil = new RegexBlocosEfdUtil();
        try {
            List<String[]> linhas = encontrarBlocosEfdUtil.obterBlocoD("C:\\PROJETOS\\SPED\\F0905293_SRF+SRF1_EFD_003-9951-SpedEFD-10953876000106-133745287-1-202002-15072020151246-014-15072020153842.txt");
            for (String[] linha : linhas) {
                System.out.println(linha[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
