/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.efd;
import br.com.sped.scf.model.entity.efd.bloco0.Bloco0;
import br.com.sped.scf.model.entity.efd.blococ.BlocoC;
import br.com.sped.scf.model.entity.efd.blocod.BlocoD;
import br.com.sped.scf.model.entity.efd.blocoe.RegistroE110;
/**
 *
 * @author dario
 */
public class Efd {

    Bloco0 bloco0;
    BlocoC blocoC;
    BlocoD blocoD;

    
    public BlocoC getBlocoC() {
		return blocoC;
	}

	public void setBlocoC(BlocoC blocoC) {
		this.blocoC = blocoC;
	}

	RegistroE110 registroE110;


    public BlocoD getBlocoD() {
		return blocoD;
	}

	public void setBlocoD(BlocoD blocoD) {
		this.blocoD = blocoD;
	}

	public RegistroE110 getRegistroE110() {
        return registroE110;
    }

    public void setRegistroE110(RegistroE110 registroE110) {
        this.registroE110 = registroE110;
    }

	public Bloco0 getBloco0() {
		return bloco0;
	}

	public void setBloco0(Bloco0 bloco0) {
		this.bloco0 = bloco0;
	}

   
    
 

    
    
}
