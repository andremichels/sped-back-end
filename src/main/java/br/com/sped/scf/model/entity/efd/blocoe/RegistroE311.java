/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.blocoe;

import java.math.BigDecimal;

/**
 *
 * @author dario
 */
public class RegistroE311 {
    String codAjApur;
    String descrComplAj;
    BigDecimal vlAjApur;

    public String getCodAjApur() {
        return codAjApur;
    }

    public void setCodAjApur(String codAjApur) {
        this.codAjApur = codAjApur;
    }

    public String getDescrComplAj() {
        return descrComplAj;
    }

    public void setDescrComplAj(String descrComplAj) {
        this.descrComplAj = descrComplAj;
    }

    public BigDecimal getVlAjApur() {
        return vlAjApur;
    }

    public void setVlAjApur(BigDecimal vlAjApur) {
        this.vlAjApur = vlAjApur;
    }
    
    
}
