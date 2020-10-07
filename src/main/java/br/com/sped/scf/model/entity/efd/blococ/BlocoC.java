/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.blococ;

import java.util.List;

/**
 *
 * @author dario
 */
public class BlocoC {

    List<RegistroC100> registroC100;

    public List<RegistroC100> getRegistroC100() {
        return registroC100;
    }
    public RegistroC100 firstRegistroC100(){
        if(registroC100 != null &&  !registroC100.isEmpty() )
           return  registroC100.get(0);
        else 
            return null;
    }

    public void setRegistroC100(List<RegistroC100> registroC100) {
        this.registroC100 = registroC100;
    }

}
