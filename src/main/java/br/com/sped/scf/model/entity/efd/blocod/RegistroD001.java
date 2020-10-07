package br.com.sped.scf.model.entity.efd.blocod;

import java.util.List;

public class RegistroD001 {

	String indMov;
	List<RegistroD100> registroD100;

	public String getIndMov() {
		return indMov;
	}
	public void setIndMov(String indMov) {
		this.indMov = indMov;
	}
	public List<RegistroD100> getRegistroD100() {
		return registroD100;
	}
	public void setRegistroD100(List<RegistroD100> registroD100) {
		this.registroD100 = registroD100;
	}
	
}
