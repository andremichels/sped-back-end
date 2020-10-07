/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util.efd;

import br.com.sped.scf.model.entity.efd.Efd;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE110;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE111;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE112;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE115;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE116;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE200;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE210;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE220;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE250;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE310;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE311;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE316;
import br.com.sped.scf.model.util.ReadLineUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */
public class ReadBlocoEUtil {

    RegistroE110 regE110;
    List<RegistroE111> registroE111List;
    RegistroE111 registroE111;
    List<RegistroE112> registroE112List;
    RegistroE112 registroE112;
    RegistroE115 registroE115;
    List<RegistroE115> registroE115List;
    RegistroE116 registroE116;
    List<RegistroE116> registroE116List;
    RegistroE200 regE200;
    RegistroE210 regE210;
    RegistroE220 regE220;
    RegistroE250 regE250;
    List<RegistroE220> registroE220List;
    List<RegistroE250> registroE250List;
    Efd efd;

    public void processarBlocoE(List<String[]> blocoList, Efd efd) throws ParseException {
        this.efd = efd;
        for (String[] linha : blocoList) {
            if (linha.length == 0) {
                continue;
            }

            switch (linha[0]) {
                case "E110":
                    regE110 = lerRegistroE110(linha);
                    efd.setRegistroE110(regE110);
                    registroE111List = new ArrayList<>();
                    regE110.setRegistroE111(registroE111List);
                    registroE115List = new ArrayList<>();
                    regE110.setRegistroE115(registroE115List);
                    registroE116List = new ArrayList<>();
                    regE110.setRegistroE116(registroE116List);
                    break;
                case "E111":
                    registroE111 = lerRegistroE111(linha);
                    registroE112List = new ArrayList<>();
                    registroE111.setRegistroE112(registroE112List);
                    registroE111List.add(registroE111);
                    break;
                case "E112":
                    registroE112 = lerRegistroE112(linha);
                    registroE112List.add(registroE112);
                    break;
                case "E115":
                    registroE115 = lerRegistroE115(linha);
                    registroE115List.add(registroE115);
                    break;
                case "E116":
                    registroE116 = lerRegistroE116(linha);
                    registroE116List.add(registroE116);
                    break;
                case "E200":
                    regE200 = lerRegistroE200(linha);
                    break;
                case "E210":
                    regE210 = lerRegistroE210(linha);
                    registroE220List = new ArrayList<>();
                    registroE250List = new ArrayList<>();
                    regE210.setRegistroE220(registroE220List);
                    regE210.setRegistroE250(registroE250List);
                    break;
                case "E220":
                    regE220 = lerRegistroE220(linha);
                    registroE220List.add(regE220);
                    break;
                case "E250":
                    regE250 = lerRegistroE250(linha);
                    registroE250List.add(regE250);
                    break;
                case "E310":
                    break;
                case "E311":
                    break;
                case "E316":
                    break;
                default:
                    break;
            }

        }
        if (regE110.getRegistroE111() != null && regE110.getRegistroE111().isEmpty()) {
            regE110.setRegistroE111(null);
        }
        if (regE110.getRegistroE111() != null && regE110.getRegistroE111().isEmpty()) {
            regE110.setRegistroE111(null);
        }
        if (regE110.getRegistroE115() != null && regE110.getRegistroE115().isEmpty()) {
            regE110.setRegistroE115(null);
        }
        if (regE110.getRegistroE115() != null && regE110.getRegistroE115().isEmpty()) {
            regE110.setRegistroE115(null);
        }
        if (regE110.getRegistroE116() != null && regE110.getRegistroE116().isEmpty()) {
            regE110.setRegistroE116(null);
        }

    }

    private RegistroE110 lerRegistroE110(String[] row) throws ParseException {
        RegistroE110 registroE110 = new RegistroE110();
        int i = 1;
        registroE110.setVlTotDebitos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlAjDebitos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlAjDebitos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlTotAjDebitos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlEstornosCred(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlTotCreditos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlAjCreditos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlTotAjCreditos(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlEstornosDeb(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlSldCredorAnt(ReadLineUtil.castBigDecimal(row, i++));
        registroE110.setVlSldApurado(ReadLineUtil.castBigDecimal(row, i++));
        return registroE110;
    }

    private RegistroE111 lerRegistroE111(String[] row) throws ParseException {
        RegistroE111 registroE111 = new RegistroE111();
        int i = 1;
        registroE111.setCodAjApur(ReadLineUtil.castString(row, i++));
        registroE111.setDescrComplAj(ReadLineUtil.castString(row, i++));
        registroE111.setVlAjApur(ReadLineUtil.castBigDecimal(row, i++));
        return registroE111;
    }

    private RegistroE112 lerRegistroE112(String[] row) throws ParseException {
        RegistroE112 registroE112 = new RegistroE112();
        int i = 1;
        registroE112.setNumDa(ReadLineUtil.castString(row, i++));
        registroE112.setNumProc(ReadLineUtil.castString(row, i++));
        registroE112.setIndProc(ReadLineUtil.castString(row, i++));
        registroE112.setProc(ReadLineUtil.castString(row, i++));
        registroE112.setTxtCompl(ReadLineUtil.castString(row, i++));
        return registroE112;
    }

    private RegistroE115 lerRegistroE115(String[] row) throws ParseException {
        RegistroE115 registroE115 = new RegistroE115();
        int i = 1;
        registroE115.setCodInfAdic(ReadLineUtil.castString(row, i++));
        registroE115.setVlInfAdic(ReadLineUtil.castBigDecimal(row, i++));
        registroE115.setDescrComplAj(ReadLineUtil.castString(row, i++));
        return registroE115;
    }

    private RegistroE116 lerRegistroE116(String[] row) throws ParseException {
        RegistroE116 registroE116 = new RegistroE116();
        int i = 1;
        registroE116.setCodOr(ReadLineUtil.castString(row, i++));
        registroE116.setVlOr(ReadLineUtil.castBigDecimal(row, i++));
        registroE116.setDtVcto(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registroE116.setCodRec(ReadLineUtil.castString(row, i++));
        registroE116.setNumProc(ReadLineUtil.castString(row, i++));
        registroE116.setIndProc(ReadLineUtil.castString(row, i++));
        registroE116.setProc(ReadLineUtil.castString(row, i++));
        registroE116.setTxtCompl(ReadLineUtil.castString(row, i++));
        registroE116.setMesRef(ReadLineUtil.castInteger(row, i++));
        return registroE116;
    }

    private RegistroE200 lerRegistroE200(String[] row) throws ParseException {
        RegistroE200 registroE200 = new RegistroE200();
        int i = 1;
        registroE200.setUf(ReadLineUtil.castString(row, i++));
        registroE200.setDtIni(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registroE200.setDtfin(ReadLineUtil.castDateAAAAMMDD(row, i++));

        return registroE200;
    }

    private RegistroE210 lerRegistroE210(String[] row) throws ParseException {
        RegistroE210 registroE210 = new RegistroE210();
        int i = 1;
        registroE210.setIndMovSt(ReadLineUtil.castString(row, i++));
        registroE210.setVlSldCredAntSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlDevolSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlRessarcSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlOutCredSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlAjCreditosSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlRetencaoSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlOutDebSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlAjDebitosSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlSldDevAntSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlDevolucoesSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlIcmsRecolSt(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlSldCredStTransportar(ReadLineUtil.castBigDecimal(row, i++));
        registroE210.setVlDebEspSt(ReadLineUtil.castBigDecimal(row, i++));
        return registroE210;
    }

    private RegistroE220 lerRegistroE220(String[] row) throws ParseException {
        RegistroE220 registroE210 = new RegistroE220();
        int i = 1;
        registroE210.setCodAjApur(ReadLineUtil.castString(row, i++));
        registroE210.setVlAjApur(ReadLineUtil.castBigDecimal(row, i++));
        return registroE210;
    }

    private RegistroE250 lerRegistroE250(String[] row) throws ParseException {
        RegistroE250 registroE250 = new RegistroE250();
        int i = 1;
        registroE250.setCodOr(ReadLineUtil.castString(row, i++));
        registroE250.setVlOr(ReadLineUtil.castBigDecimal(row, i++));
        registroE250.setCodRec(ReadLineUtil.castString(row, i++));
        registroE250.setNumProc(ReadLineUtil.castString(row, i++));
        registroE250.setIndProc(ReadLineUtil.castString(row, i++));
        registroE250.setProc(ReadLineUtil.castString(row, i++));
        registroE250.setTxtCompl(ReadLineUtil.castString(row, i++));
        registroE250.setMesRef(ReadLineUtil.castInteger(row, i++));

        return registroE250;
    }

    private RegistroE310 lerRegistroE310(String[] row) throws ParseException {
        RegistroE310 registroE310 = new RegistroE310();
        int i = 1;
        registroE310.setIndMovDifal(ReadLineUtil.castString(row, i++));
        registroE310.setVlSldCredAntDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlTotDebitosDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlOutDebDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlTotDebitosDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlTotDebFcp(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlTotCreditosDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlTotCredFcp(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlOutCredDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlSldDevAntDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlDeducoesDifal(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlRecol(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlSldCredTransportar(ReadLineUtil.castBigDecimal(row, i++));
        registroE310.setVlDebEspDifal(ReadLineUtil.castBigDecimal(row, i++));
        return registroE310;
    }

    private RegistroE311 lerRegistroE311(String[] row) throws ParseException {
        RegistroE311 registroE311 = new RegistroE311();
        int i = 1;
        registroE311.setCodAjApur(ReadLineUtil.castString(row, i++));
        registroE311.setDescrComplAj(ReadLineUtil.castString(row, i++));
        registroE311.setVlAjApur(ReadLineUtil.castBigDecimal(row, i++));
        return registroE311;
    }

    private RegistroE316 lerRegistroE316(String[] row) throws ParseException {
        RegistroE316 registroE316 = new RegistroE316();
        int i = 1;
        registroE316.setCodOr(ReadLineUtil.castString(row, i++));
        registroE316.setVlOr(ReadLineUtil.castBigDecimal(row, i++));
        registroE316.setDtVcto(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registroE316.setCodRec(ReadLineUtil.castString(row, i++));
        registroE316.setNumProc(ReadLineUtil.castString(row, i++));
        registroE316.setIndProc(ReadLineUtil.castString(row, i++));
        registroE316.setProc(ReadLineUtil.castString(row, i++));
        registroE316.setTxtCompl(ReadLineUtil.castString(row, i++));
        registroE316.setMesRef(ReadLineUtil.castInteger(row, i++));
        return registroE316;
    }

}
