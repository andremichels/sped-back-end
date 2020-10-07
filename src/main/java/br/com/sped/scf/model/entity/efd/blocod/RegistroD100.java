/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.blocod;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dario
 */
public class RegistroD100 {

	RegistroD101  registroD101;
	List<RegistroD190> registroD190;
	List<RegistroD195> registroD195;
	String indOper;
    String indEmit;
    String codPart;
    String codMod;
    Integer codSit;
    String ser;
    String sub;
    Integer numDoc;
    String chvCte;
    Date dtDoc;
    Date dtAp;
    Integer tpCte;
    String chvCteRef;
    BigDecimal vlDoc;
    BigDecimal vlDesc;
    String indFrt;
    BigDecimal vlServ;
    BigDecimal vlBcIcms;
    BigDecimal vlIcms;
    BigDecimal vlNt;
    String codInf;
    String codCta;
    Integer codMunOrig;
    Integer codMunDest;

    
    
    
    public RegistroD101 getRegistroD101() {
		return registroD101;
	}

	public void setRegistroD101(RegistroD101 registroD101) {
		this.registroD101 = registroD101;
	}

	public List<RegistroD190> getRegistroD190() {
		return registroD190;
	}

	public void setRegistroD190(List<RegistroD190> registroD190) {
		this.registroD190 = registroD190;
	}

	public List<RegistroD195> getRegistroD195() {
		return registroD195;
	}

	public void setRegistroD195(List<RegistroD195> registroD195) {
		this.registroD195 = registroD195;
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
        this.ser = ser;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getChvCte() {
        return chvCte;
    }

    public void setChvCte(String chvCte) {
        this.chvCte = chvCte;
    }

    public Date getDtDoc() {
        return dtDoc;
    }

    public void setDtDoc(Date dtDoc) {
        this.dtDoc = dtDoc;
    }

    public Date getDtAp() {
        return dtAp;
    }

    public void setDtAp(Date dtAp) {
        this.dtAp = dtAp;
    }

    public Integer getTpCte() {
        return tpCte;
    }

    public void setTpCte(Integer tpCte) {
        this.tpCte = tpCte;
    }

    public String getChvCteRef() {
        return chvCteRef;
    }

    public void setChvCteRef(String chvCteRef) {
        this.chvCteRef = chvCteRef;
    }

    public BigDecimal getVlDoc() {
        return vlDoc;
    }

    public void setVlDoc(BigDecimal vlDoc) {
        this.vlDoc = vlDoc;
    }

    public BigDecimal getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(BigDecimal vlDesc) {
        this.vlDesc = vlDesc;
    }

    public String getIndFrt() {
        return indFrt;
    }

    public void setIndFrt(String indFrt) {
        this.indFrt = indFrt;
    }

    public BigDecimal getVlServ() {
        return vlServ;
    }

    public void setVlServ(BigDecimal vlServ) {
        this.vlServ = vlServ;
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

    public BigDecimal getVlNt() {
        return vlNt;
    }

    public void setVlNt(BigDecimal vlNt) {
        this.vlNt = vlNt;
    }

    public String getCodInf() {
        return codInf;
    }

    public void setCodInf(String codInf) {
        this.codInf = codInf;
    }

    public String getCodCta() {
        return codCta;
    }

    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }

    public Integer getCodMunOrig() {
        return codMunOrig;
    }

    public void setCodMunOrig(Integer codMunOrig) {
        this.codMunOrig = codMunOrig;
    }

    public Integer getCodMunDest() {
        return codMunDest;
    }

    public void setCodMunDest(Integer codMunDest) {
        this.codMunDest = codMunDest;
    }
    
    
}
