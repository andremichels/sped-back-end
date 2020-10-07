/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.blocoe;

import java.math.BigDecimal;

import java.util.List;
/**
 *
 * @author dario
 */
public class RegistroE210 {
    
    List<RegistroE220> registroE220;
    List<RegistroE250> registroE250;
    String indMovSt;
    BigDecimal vlSldCredAntSt;
    BigDecimal vlDevolSt;
    BigDecimal vlRessarcSt;
    BigDecimal vlOutCredSt;
    BigDecimal vlAjCreditosSt;
    BigDecimal vlRetencaoSt;
    BigDecimal vlOutDebSt;
    BigDecimal vlAjDebitosSt;
    BigDecimal vlSldDevAntSt;
    BigDecimal vlDevolucoesSt;
    BigDecimal vlIcmsRecolSt;
    BigDecimal vlSldCredStTransportar;
    BigDecimal vlDebEspSt;

    public List<RegistroE250> getRegistroE250() {
        return registroE250;
    }

    public void setRegistroE250(List<RegistroE250> registroE250) {
        this.registroE250 = registroE250;
    }



    public List<RegistroE220> getRegistroE220() {
        return registroE220;
    }

    public void setRegistroE220(List<RegistroE220> registroE220) {
        this.registroE220 = registroE220;
    }
    
    public String getIndMovSt() {
        return indMovSt;
    }

    public void setIndMovSt(String indMovSt) {
        this.indMovSt = indMovSt;
    }

    public BigDecimal getVlSldCredAntSt() {
        return vlSldCredAntSt;
    }

    public void setVlSldCredAntSt(BigDecimal vlSldCredAntSt) {
        this.vlSldCredAntSt = vlSldCredAntSt;
    }

    public BigDecimal getVlDevolSt() {
        return vlDevolSt;
    }

    public void setVlDevolSt(BigDecimal vlDevolSt) {
        this.vlDevolSt = vlDevolSt;
    }

    public BigDecimal getVlRessarcSt() {
        return vlRessarcSt;
    }

    public void setVlRessarcSt(BigDecimal vlRessarcSt) {
        this.vlRessarcSt = vlRessarcSt;
    }

    public BigDecimal getVlOutCredSt() {
        return vlOutCredSt;
    }

    public void setVlOutCredSt(BigDecimal vlOutCredSt) {
        this.vlOutCredSt = vlOutCredSt;
    }

    public BigDecimal getVlAjCreditosSt() {
        return vlAjCreditosSt;
    }

    public void setVlAjCreditosSt(BigDecimal vlAjCreditosSt) {
        this.vlAjCreditosSt = vlAjCreditosSt;
    }

    public BigDecimal getVlRetencaoSt() {
        return vlRetencaoSt;
    }

    public void setVlRetencaoSt(BigDecimal vlRetencaoSt) {
        this.vlRetencaoSt = vlRetencaoSt;
    }

    public BigDecimal getVlOutDebSt() {
        return vlOutDebSt;
    }

    public void setVlOutDebSt(BigDecimal vlOutDebSt) {
        this.vlOutDebSt = vlOutDebSt;
    }

    public BigDecimal getVlAjDebitosSt() {
        return vlAjDebitosSt;
    }

    public void setVlAjDebitosSt(BigDecimal vlAjDebitosSt) {
        this.vlAjDebitosSt = vlAjDebitosSt;
    }

    public BigDecimal getVlSldDevAntSt() {
        return vlSldDevAntSt;
    }

    public void setVlSldDevAntSt(BigDecimal vlSldDevAntSt) {
        this.vlSldDevAntSt = vlSldDevAntSt;
    }

    public BigDecimal getVlDevolucoesSt() {
        return vlDevolucoesSt;
    }

    public void setVlDevolucoesSt(BigDecimal vlDevolucoesSt) {
        this.vlDevolucoesSt = vlDevolucoesSt;
    }

    public BigDecimal getVlIcmsRecolSt() {
        return vlIcmsRecolSt;
    }

    public void setVlIcmsRecolSt(BigDecimal vlIcmsRecolSt) {
        this.vlIcmsRecolSt = vlIcmsRecolSt;
    }

    public BigDecimal getVlSldCredStTransportar() {
        return vlSldCredStTransportar;
    }

    public void setVlSldCredStTransportar(BigDecimal vlSldCredStTransportar) {
        this.vlSldCredStTransportar = vlSldCredStTransportar;
    }

    public BigDecimal getVlDebEspSt() {
        return vlDebEspSt;
    }

    public void setVlDebEspSt(BigDecimal vlDebEspSt) {
        this.vlDebEspSt = vlDebEspSt;
    }
    
    
    
}
