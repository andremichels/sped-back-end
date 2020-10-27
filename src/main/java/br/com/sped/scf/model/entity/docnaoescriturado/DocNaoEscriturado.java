/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.docnaoescriturado;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author dario
 */
@Document(collection = "DocNaoEscriturado")
public class DocNaoEscriturado {

    @Id
    public String id;
    private String chaveDoc;
    private String cnpjEmissor;
    private String cpfEmissor;
    private BigDecimal valorDoc;
    private BigDecimal valorImcs;
    private BigDecimal valorImcsSt;
    private String documento;
    private String tipoDocumentoFiscal;
    private Integer anoMes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChaveDoc() {
        return chaveDoc;
    }

    public void setChaveDoc(String chaveDoc) {
        this.chaveDoc = chaveDoc;
    }

    public String getCnpjEmissor() {
        return cnpjEmissor;
    }

    public void setCnpjEmissor(String cnpjEmissor) {
        this.cnpjEmissor = cnpjEmissor;
    }

    public String getCpfEmissor() {
        return cpfEmissor;
    }

    public void setCpfEmissor(String cpfEmissor) {
        this.cpfEmissor = cpfEmissor;
    }

    public BigDecimal getValorDoc() {
        return valorDoc;
    }

    public void setValorDoc(BigDecimal valorDoc) {
        this.valorDoc = valorDoc;
    }
    public void setValorDoc(Double valorDoc) {
        this.valorDoc = new BigDecimal(valorDoc);
    }
    public void setValorDoc(String valorDoc) {
        this.valorDoc = new BigDecimal(valorDoc);
    }    


    public BigDecimal getValorImcs() {
        return valorImcs;
    }

    public void setValorImcs(BigDecimal valorImcs) {
        this.valorImcs = valorImcs;
    }
    public void setValorImcs(Double valorImcs) {
        this.valorImcs = new BigDecimal(valorImcs);
    }
    public void setValorImcs(String valorImcs) {
        this.valorImcs = new BigDecimal(valorImcs);
    }

    
    public BigDecimal getValorImcsSt() {
        return valorImcsSt;
    }

    public void setValorImcsSt(BigDecimal valorImcsSt) {
        this.valorImcsSt = valorImcsSt;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumentoFiscal() {
        return tipoDocumentoFiscal;
    }

    public void setTipoDocumentoFiscal(String tipoDocumentoFiscal) {
        this.tipoDocumentoFiscal = tipoDocumentoFiscal;
    }

    public Integer getAnoMes() {
        return anoMes;
    }

    public void setAnoMes(Integer anoMes) {
        this.anoMes = anoMes;
    }

    
    
    

}
