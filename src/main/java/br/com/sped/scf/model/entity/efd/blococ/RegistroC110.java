package br.com.sped.scf.model.entity.efd.blococ;

import java.util.List;

public class RegistroC110 {

	List<RegistroC113> registroC113;
	String codInf;
	String txtCompl;
	public List<RegistroC113> getRegistroC113() {
		return registroC113;
	}
	public void setRegistroC113(List<RegistroC113> registroC113) {
		this.registroC113 = registroC113;
	}
	public String getCodInf() {
		return codInf;
	}
	public void setCodInf(String codInf) {
		this.codInf = codInf;
	}
	public String getTxtCompl() {
		return txtCompl;
	}
	public void setTxtCompl(String txtCompl) {
		this.txtCompl = txtCompl;
	}
	
}
