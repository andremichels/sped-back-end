/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util.efd;

import br.com.sped.scf.model.entity.efd.Efd;
import br.com.sped.scf.model.entity.efd.blococ.BlocoC;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC100;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC101;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC105;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC110;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC113;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC190;
import br.com.sped.scf.model.entity.efd.blococ.RegistroC191;
import br.com.sped.scf.model.util.ReadLineUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */
public class ReadBlocoCUtil {

    List<RegistroC100> registroC100List = null;
    RegistroC100 registroC100;
    RegistroC101 registroC101;
    RegistroC105 registroC105;
    RegistroC110 registroC110;
    List<RegistroC110> registroC110List;
    RegistroC113 registroC113;
    List<RegistroC113> registroC113List;    
    RegistroC190 registroC190;
    List<RegistroC190> registroC190List;

    RegistroC191 registroC191 = null;
    Efd efd;

    public void processarBlocoC(List<String[]> blocoList, Efd efd) throws ParseException {

        this.efd = efd;
        BlocoC blocoC = new BlocoC();
        for (String[] linha : blocoList) {
            if (linha.length == 0) {
                break;
            }
            switch (linha[0]) {
                case "C100"://nivel 2
                	efd.setBlocoC(blocoC);
                    registroC100 = lerRegistroC100(linha);
                    registroC100List = new ArrayList();
                    registroC110List  = new ArrayList();
                    registroC100List.add(registroC100);
                    registroC190List = new ArrayList();
                	blocoC.setRegistroC100(registroC100List);                    
                    break;
                case "C101"://nivel 3
                    registroC101 = lerRegistroC101(linha);
                    registroC100.setRegistroC101(registroC101);
                    break;
                case "C105"://nivel 3
                    registroC105 = lerRegistroC105(linha);
                    registroC100.setRegistroC105(registroC105);
                    break;
                case "C110":
                	registroC110 = lerRegistroC110(linha);
                	registroC110List.add(registroC110);
                	registroC100.setRegistroC110(registroC110List);
                    registroC113List  = new ArrayList();                	
                    break;
                case "C113":
                      registroC113 = lerRegistroC113(linha); 
                      registroC113List.add(registroC113);
                      registroC110.setRegistroC113(registroC113List);
                    break;
                case "C190":
                    registroC190 = lerRegistroC190(linha);
                    registroC190List.add(registroC190);
                    registroC100.setRegistroC190(registroC190List);
                    break;
                case "C191":
                    registroC191 = lerRegistroC191(linha);
                    registroC190.setRegistroC191(registroC191);
                    break;
                default:
                    break;
            }
        }
    }

    private RegistroC100 lerRegistroC100(String[] row) throws ParseException {

        RegistroC100 registroC100 = new RegistroC100();
        int i = 1;
        registroC100.setIndOper(ReadLineUtil.castString(row, i++));
        registroC100.setIndEmit(ReadLineUtil.castString(row, i++));
        registroC100.setCodPart(ReadLineUtil.castString(row, i++));
        registroC100.setCodMod(ReadLineUtil.castString(row, i++));
        registroC100.setCodSit(ReadLineUtil.castInteger(row, i++));
        registroC100.setSer(ReadLineUtil.castString(row, i++));
        registroC100.setNumDoc(ReadLineUtil.castInteger(row, i++));
        registroC100.setChvNfe(ReadLineUtil.castString(row, i++));
        registroC100.setDtDoc(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registroC100.setDtES(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registroC100.setIndPgto(ReadLineUtil.castString(row, i++));
        registroC100.setVlDesc(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlAbatNt(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlMerc(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setIndFrt(ReadLineUtil.castString(row, i++));
        registroC100.setVlFrt(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlSeg(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlOutDa(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlBcIcms(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlIcms(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlBcIcmsSt(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlIcmsSt(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlIpi(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlPis(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlCofins(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlPisSt(ReadLineUtil.castBigDecimal(row, i++));
        registroC100.setVlCofinsSt(ReadLineUtil.castBigDecimal(row, i++));
        return registroC100;
    }

    private RegistroC101 lerRegistroC101(String[] row) throws ParseException {
        RegistroC101 registroC101 = new RegistroC101();
        int i = 1;
        registroC101.setVlFcpUfDest(ReadLineUtil.castBigDecimal(row, i++));
        registroC101.setVlIcmsUfDest(ReadLineUtil.castBigDecimal(row, i++));
        registroC101.setVlIcmsUfRem(ReadLineUtil.castBigDecimal(row, i++));
        return registroC101;
    }

    private RegistroC105 lerRegistroC105(String[] row) throws ParseException {
        RegistroC105 registroC105 = new RegistroC105();
        int i = 1;
        registroC105.setOper(ReadLineUtil.castInteger(row, i++));
        registroC105.setUf(ReadLineUtil.castString(row, i++));

        return registroC105;
    }
    private RegistroC110 lerRegistroC110(String[] row) throws ParseException {
        RegistroC110 registroC110 = new RegistroC110();
        int i = 1;
        registroC110.setCodInf(ReadLineUtil.castString(row, i++));
        registroC110.setTxtCompl(ReadLineUtil.castString(row, i++));
        return registroC110;
    }


    
    
    private RegistroC113 lerRegistroC113(String[] row) throws ParseException {
        RegistroC113 registroC113 = new RegistroC113();
        int i = 1;
        registroC113.setIndOper(ReadLineUtil.castString(row, i++));
        registroC113.setIndEmit(ReadLineUtil.castString(row, i++));
        registroC113.setCodPart(ReadLineUtil.castString(row, i++));
        registroC113.setCodMod(ReadLineUtil.castString(row, i++));
        registroC113.setSer(ReadLineUtil.castString(row, i++));
        registroC113.setSub(ReadLineUtil.castString(row, i++));
        registroC113.setNumDoc(ReadLineUtil.castInteger(row, i++));
        registroC113.setDtDoc(ReadLineUtil.castDateAAAAMMDD(row, i++));
        registroC113.setChvDocE(ReadLineUtil.castString(row, i++));

        return registroC113;
    }

    private RegistroC190 lerRegistroC190(String[] row) throws ParseException {
        RegistroC190 registroC190 = new RegistroC190();
        int i = 1;
        registroC190.setCstIcms(ReadLineUtil.castInteger(row, i++));
        registroC190.setCfop(ReadLineUtil.castInteger(row, i++));
        registroC190.setAliqIcms(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlOpr(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlBcIcms(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlIcms(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlBcIcmsSt(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlIcmsSt(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlRedBc(ReadLineUtil.castBigDecimal(row, i++));
        registroC190.setVlIpi(ReadLineUtil.castBigDecimal(row, i++));

        return registroC190;
    }

    private RegistroC191 lerRegistroC191(String[] row) throws ParseException {
        RegistroC191 registroC191 = new RegistroC191();
        int i = 1;
        registroC191.setVlFcpOp(ReadLineUtil.castBigDecimal(row, i++));
        registroC191.setVlFcpSt(ReadLineUtil.castBigDecimal(row, i++));
        registroC191.setVlFcpRet(ReadLineUtil.castBigDecimal(row, i++));
        return registroC191;
    }

}
