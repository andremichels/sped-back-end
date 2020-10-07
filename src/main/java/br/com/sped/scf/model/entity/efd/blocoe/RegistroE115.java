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

public class RegistroE115 {

    String codInfAdic;
    BigDecimal vlInfAdic;
    String descrComplAj;

    public String getCodInfAdic() {
        return codInfAdic;
    }

    public void setCodInfAdic(String codInfAdic) {
        this.codInfAdic = codInfAdic;
    }

    public BigDecimal getVlInfAdic() {
        return vlInfAdic;
    }

    public void setVlInfAdic(BigDecimal vlInfAdic) {
        this.vlInfAdic = vlInfAdic;
    }

    public String getDescrComplAj() {
        return descrComplAj;
    }

    public void setDescrComplAj(String descrComplAj) {
        this.descrComplAj = descrComplAj;
    }
    
}
