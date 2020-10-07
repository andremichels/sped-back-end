/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd.bloco0;

import java.util.List;

/**
 *
 * @author dario
 */
public class Bloco0 {
    Registro0000 registro0000;
    Registro0100 registro0100;
    List<Registro0015> registro0015;
    List<Registro0150>  registro0150;


    public Registro0000 getRegistro0000() {
        return registro0000;
    }

    public List<Registro0015> getRegistro0015() {
        return registro0015;
    }

    public void setRegistro0015(List<Registro0015> registro0015) {
        this.registro0015 = registro0015;
    }

    public List<Registro0150> getRegistro0150() {
        return registro0150;
    }

    public void setRegistro0150(List<Registro0150> registro0150) {
        this.registro0150 = registro0150;
    }

    public void setRegistro0000(Registro0000 registro0000) {
        this.registro0000 = registro0000;
    }


    public Registro0100 getRegistro0100() {
        return registro0100;
    }

    public void setRegistro0100(Registro0100 registro0100) {
        this.registro0100 = registro0100;
    }

  
    
}
