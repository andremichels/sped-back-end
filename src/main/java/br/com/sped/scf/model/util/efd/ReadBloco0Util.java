/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util.efd;

import br.com.sped.scf.model.entity.efd.Efd;
import br.com.sped.scf.model.entity.efd.bloco0.Bloco0;
import br.com.sped.scf.model.entity.efd.bloco0.Registro0000;
import br.com.sped.scf.model.entity.efd.bloco0.Registro0015;
import br.com.sped.scf.model.entity.efd.bloco0.Registro0100;
import br.com.sped.scf.model.entity.efd.bloco0.Registro0150;
import br.com.sped.scf.model.util.ReadLineUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */
public class ReadBloco0Util {

    Registro0000 registro0000;
    Registro0015 registro0015;
    Registro0100 registro0100;
    Registro0150 registro0150;
    Efd efd;

    public void processarBloco0(List<String[]> bloco0List, Efd efd) throws ParseException {
        List<Registro0015> registro0015List = new ArrayList<>();
        List<Registro0150> registro0150List = new ArrayList<>();
        Bloco0 bloco0 = new Bloco0();
        this.efd = efd;
        efd.setBloco0(bloco0);

        for (String[] linha : bloco0List) {
            if (linha.length == 0) {
                break;
            }
            switch (linha[0]) {
                case "0000":
                    registro0000 = lerRegistro0000(linha);
                    bloco0.setRegistro0000(registro0000);

                    break;
                case "0015":
                    registro0015 = lerRegistro0015(linha);
                    registro0015List.add(registro0015);
                    bloco0.setRegistro0015(registro0015List);
                    break;
                case "0100":
                    registro0100 = lerRegistro0100(linha);
                    bloco0.setRegistro0100(registro0100);
                    break;
                case "0150":
                    registro0150 = lerRegistro0150(linha);
                    registro0150List.add(registro0150);
                    bloco0.setRegistro0150(registro0150List);
                    break;
                default:
                    break;
            }
        }
    }

    private Registro0000 lerRegistro0000(String[] row) throws ParseException {
        Registro0000 registro0000 = new Registro0000();
        int i = 1;
        registro0000.setCodVer(ReadLineUtil.castInteger(row, i++));
        registro0000.setCodFin(ReadLineUtil.castInteger(row, i++));
        registro0000.setDtIni(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registro0000.setDtFin(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registro0000.setNome(ReadLineUtil.castString(row, i++));
        registro0000.setCnpj(ReadLineUtil.castString(row, i++));
        registro0000.setCpf(ReadLineUtil.castString(row, i++));
        registro0000.setUf(ReadLineUtil.castString(row, i++));
        registro0000.setIe(ReadLineUtil.castString(row, i++));
        registro0000.setCodMun(ReadLineUtil.castInteger(row, i++));
        registro0000.setIm(ReadLineUtil.castString(row, i++));
        registro0000.setSuframa(ReadLineUtil.castString(row, i++));
        return registro0000;
    }

    private Registro0015 lerRegistro0015(String[] row) throws ParseException {
        Registro0015 registro0015 = new Registro0015();
        int i = 1;
        registro0015.setUfSt(ReadLineUtil.castString(row, i++));
        registro0015.setIeSt(ReadLineUtil.castString(row, i++));
        return registro0015;
    }

    private Registro0100 lerRegistro0100(String[] row) throws ParseException {

        Registro0100 registro0100 = new Registro0100();
        int i = 1;
        registro0100.setNome(ReadLineUtil.castString(row, i++));
        registro0100.setCpf(ReadLineUtil.castString(row, i++));
        registro0100.setCrc(ReadLineUtil.castString(row, i++));
        registro0100.setCnpj(ReadLineUtil.castString(row, i++));
        registro0100.setCep(ReadLineUtil.castInteger(row, i++));
        registro0100.setEnd(ReadLineUtil.castString(row, i++));
        registro0100.setNum(ReadLineUtil.castString(row, i++));
        registro0100.setCompl(ReadLineUtil.castString(row, i++));
        registro0100.setBairro(ReadLineUtil.castString(row, i++));
        registro0100.setFone(ReadLineUtil.castString(row, i++));
        registro0100.setFax(ReadLineUtil.castString(row, i++));
        registro0100.setEmail(ReadLineUtil.castString(row, i++));
        registro0100.setCodmun(ReadLineUtil.castInteger(row, i++));
        return registro0100;

    }

    private Registro0150 lerRegistro0150(String[] row) throws ParseException {

        Registro0150 registro0150 = new Registro0150();
        int i = 1;
        registro0150.setCodPart(ReadLineUtil.castString(row, i++));
        registro0150.setNome(ReadLineUtil.castString(row, i++));
        registro0150.setCodPais(ReadLineUtil.castInteger(row, i++));
        registro0150.setCnpj(ReadLineUtil.castString(row, i++));
        registro0150.setCpf(ReadLineUtil.castString(row, i++));
        registro0150.setIe(ReadLineUtil.castString(row, i++));
        registro0150.setCodMun(ReadLineUtil.castInteger(row, i++));
        registro0150.setSuframa(ReadLineUtil.castString(row, i++));
        registro0150.setEnd(ReadLineUtil.castString(row, i++));
        registro0150.setNum(ReadLineUtil.castString(row, i++));
        registro0150.setCompl(ReadLineUtil.castString(row, i++));
        registro0150.setBairro(ReadLineUtil.castString(row, i++));

        return registro0150;
    }

}
