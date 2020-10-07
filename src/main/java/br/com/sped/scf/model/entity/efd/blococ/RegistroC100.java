/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.blococ;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dario
 */
public class RegistroC100 {
    RegistroC101 registroC101;
    RegistroC105 registroC105;
    List<RegistroC110> registroC110;
    List<RegistroC190> registroC190;
    String indOper;
    String indEmit;
    String codPart;
    String codMod;
    Integer codSit;
    String ser;
    Integer NumDoc;
    String chvNfe;
    Date dtDoc;
    Date dtES;
    BigDecimal vlDoc;
    String indPgto;
    BigDecimal vlDesc;
    BigDecimal vlAbatNt;
    BigDecimal vlMerc;
    String indFrt;
    BigDecimal vlFrt;
    BigDecimal vlSeg;
    BigDecimal vlOutDa;
    BigDecimal vlBcIcms;
    BigDecimal vlIcms;
    BigDecimal vlBcIcmsSt;
    BigDecimal vlIcmsSt;
    BigDecimal vlIpi;    
    BigDecimal vlPis;
    BigDecimal vlCofins;
    BigDecimal vlPisSt;
    BigDecimal vlCofinsSt;

    
    
    
    public List<RegistroC110> getRegistroC110() {
		return registroC110;
	}

	public void setRegistroC110(List<RegistroC110> registroC110) {
		this.registroC110 = registroC110;
	}

	public List<RegistroC190> getRegistroC190() {
        return registroC190;
    }

    public void setRegistroC190(List<RegistroC190> registroC190) {
        this.registroC190 = registroC190;
    }
    
    public RegistroC105 getRegistroC105() {
        return registroC105;
    }

    public void setRegistroC105(RegistroC105 registroC105) {
        this.registroC105 = registroC105;
    }

    
    
    
    public RegistroC101 getRegistroC101() {
        return registroC101;
    }

    public void setRegistroC101(RegistroC101 registroC101) {
        this.registroC101 = registroC101;
    }
    
    public BigDecimal getVlIcmsSt() {
        return vlIcmsSt;
    }

    public void setVlIcmsSt(BigDecimal vlIcmsSt) {
        this.vlIcmsSt = vlIcmsSt;
    }

  
    
    
    public String getIndOper() {
        return indOper;
    }

    public void setIndOper(String indOper) {
        this.indOper = indOper;
    }

    public String getIndEmit() {
        return indEmit;
    }

    public void setIndEmit(String indEmit) {
        this.indEmit = indEmit;
    }

    public String getCodPart() {
        return codPart;
    }

    public void setCodPart(String codPart) {
        this.codPart = codPart;
    }

    public String getCodMod() {
        return codMod;
    }

    public void setCodMod(String codMod) {
        this.codMod = codMod;
    }

    public Integer getCodSit() {
        return codSit;
    }

    public void setCodSit(Integer codSit) {
        this.codSit = codSit;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        try {
            this.ser = String.valueOf(Integer.parseInt(ser));
        } catch (Exception e) {
            this.ser =ser;
        }

        
    }

    public Integer getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(Integer NumDoc) {
        this.NumDoc = NumDoc;
    }

    public String getChvNfe() {
        return chvNfe;
    }

    public void setChvNfe(String chvNfe) {
        this.chvNfe = chvNfe;
    }

    public Date getDtDoc() {
        return dtDoc;
    }

    public void setDtDoc(Date dtDoc) {
        this.dtDoc = dtDoc;
    }

    public Date getDtES() {
        return dtES;
    }

    public void setDtES(Date dtES) {
        this.dtES = dtES;
    }

    public BigDecimal getVlDoc() {
        return vlDoc;
    }

    public void setVlDoc(BigDecimal vlDoc) {
        this.vlDoc = vlDoc;
    }

    public String getIndPgto() {
        return indPgto;
    }

    public void setIndPgto(String indPgto) {
        this.indPgto = indPgto;
    }

    public BigDecimal getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(BigDecimal vlDesc) {
        this.vlDesc = vlDesc;
    }

    public BigDecimal getVlAbatNt() {
        return vlAbatNt;
    }

    public void setVlAbatNt(BigDecimal vlAbatNt) {
        this.vlAbatNt = vlAbatNt;
    }

    public BigDecimal getVlMerc() {
        return vlMerc;
    }

    public void setVlMerc(BigDecimal vlMerc) {
        this.vlMerc = vlMerc;
    }

    public String getIndFrt() {
        return indFrt;
    }

    public void setIndFrt(String indFrt) {
        this.indFrt = indFrt;
    }

    public BigDecimal getVlFrt() {
        return vlFrt;
    }

    public void setVlFrt(BigDecimal vlFrt) {
        this.vlFrt = vlFrt;
    }

    public BigDecimal getVlSeg() {
        return vlSeg;
    }

    public void setVlSeg(BigDecimal vlSeg) {
        this.vlSeg = vlSeg;
    }

    public BigDecimal getVlOutDa() {
        return vlOutDa;
    }

    public void setVlOutDa(BigDecimal vlOutDa) {
        this.vlOutDa = vlOutDa;
    }

    public BigDecimal getVlBcIcms() {
        return vlBcIcms;
    }

    public void setVlBcIcms(BigDecimal vlBcIcms) {
        this.vlBcIcms = vlBcIcms;
    }

    public BigDecimal getVlIcms() {
        return vlIcms;
    }

    public void setVlIcms(BigDecimal vlIcms) {
        this.vlIcms = vlIcms;
    }

    public BigDecimal getVlBcIcmsSt() {
        return vlBcIcmsSt;
    }

    public void setVlBcIcmsSt(BigDecimal vlBcIcmsSt) {
        this.vlBcIcmsSt = vlBcIcmsSt;
    }

    public BigDecimal getVlIpi() {
        return vlIpi;
    }

    public void setVlIpi(BigDecimal vlIpi) {
        this.vlIpi = vlIpi;
    }

    public BigDecimal getVlPis() {
        return vlPis;
    }

    public void setVlPis(BigDecimal vlPis) {
        this.vlPis = vlPis;
    }

    public BigDecimal getVlCofins() {
        return vlCofins;
    }

    public void setVlCofins(BigDecimal vlCofins) {
        this.vlCofins = vlCofins;
    }

    public BigDecimal getVlPisSt() {
        return vlPisSt;
    }

    public void setVlPisSt(BigDecimal vlPisSt) {
        this.vlPisSt = vlPisSt;
    }

    public BigDecimal getVlCofinsSt() {
        return vlCofinsSt;
    }

    public void setVlCofinsSt(BigDecimal vlCofinsSt) {
        this.vlCofinsSt = vlCofinsSt;
    }
        
}
