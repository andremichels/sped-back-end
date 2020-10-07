/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.blocoe;

import java.util.Date;

/**
 *
 * @author dario
 */
public class RegistroE200 {
    RegistroE210 regE210;
    String uf;
    Date dtIni;
    Date dtfin;

    public RegistroE210 getRegE210() {
        return regE210;
    }

    public void setRegE210(RegistroE210 regE210) {
        this.regE210 = regE210;
    }
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Date getDtIni() {
        return dtIni;
    }

    public void setDtIni(Date dtIni) {
        this.dtIni = dtIni;
    }

    public Date getDtfin() {
        return dtfin;
    }

    public void setDtfin(Date dtfin) {
        this.dtfin = dtfin;
    }
    
}
