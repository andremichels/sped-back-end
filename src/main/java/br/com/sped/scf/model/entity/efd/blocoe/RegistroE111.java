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
public class RegistroE111 {
    List<RegistroE112> registroE112;
    String codAjApur;
    String descrComplAj;
    BigDecimal vlAjApur;

    public List<RegistroE112> getRegistroE112() {
        return registroE112;
    }

    public void setRegistroE112(List<RegistroE112> registroE112) {
        this.registroE112 = registroE112;
    }

    
    
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
