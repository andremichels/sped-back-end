/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.docnaoescriturado;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
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
    @ApiModelProperty(notes = "Chave do Documento Fiscal -44 digitos", required = false)
    private String chaveDoc;
    @ApiModelProperty(notes = "Cnpj do emissor sem zero a esquerda", required = false)
    private String cnpjEmissor;
    @ApiModelProperty(notes = "CPF do emissor sem zero a esquerda", required = false)
    private String cpfEmissor;
    @ApiModelProperty(notes = "Valor total informado no xml do documento", required = false)
    private BigDecimal valorDoc;
    @ApiModelProperty(notes = "Valor do ICMS. EFD-C100-VL_ICMS", required = false)    
    private BigDecimal valorImcs;
    @ApiModelProperty(notes = "Valor do ICMS retido por substituição tributária no xml do documento", required = false)    
    private BigDecimal valorImcsSt;
    @ApiModelProperty(notes = " Tipo Documento: NFe,CTe", required = false)
    private String documento;
    @ApiModelProperty(notes = " Entrada/Saída: NFe,CTe", required = false)
    private String tipoDocumentoFiscal;
    @ApiModelProperty(notes = " ANO 4 digitos, mes 2 digitos", required = false)
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
