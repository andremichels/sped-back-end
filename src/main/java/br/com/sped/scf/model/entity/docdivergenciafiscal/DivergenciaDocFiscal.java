/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.entity.docdivergenciafiscal;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author dario
 */
@Document(collection = "DivergenciaDocFiscal")
public class DivergenciaDocFiscal {

 @Id
  public String id;

    private String cnpjEmissor;
    private BigDecimal valorEfd;
    private BigDecimal valorDoc;
    private BigDecimal valorEfdImcs;

    private BigDecimal valorDocImcs;    
    private BigDecimal valorEfdImcsSt;
    private BigDecimal valorDocImcsSt;
    
    private String chaveDoc;
    private Integer anoMes;
    private String tipoDoc;

    public BigDecimal getValorEfdImcs() {
        return valorEfdImcs;
    }

    public void setValorEfdImcs(BigDecimal valorEfdImcs) {
        this.valorEfdImcs = valorEfdImcs;
    }

    public BigDecimal getValorDocImcs() {
        return valorDocImcs;
    }

    public void setValorDocImcs(BigDecimal valorDocImcs) {
        this.valorDocImcs = valorDocImcs;
    }

    public BigDecimal getValorEfdImcsSt() {
        return valorEfdImcsSt;
    }

    public void setValorEfdImcsSt(BigDecimal valorEfdImcsSt) {
        this.valorEfdImcsSt = valorEfdImcsSt;
    }

    public BigDecimal getValorDocImcsSt() {
        return valorDocImcsSt;
    }

    public void setValorDocImcsSt(BigDecimal valorDocImcsSt) {
        this.valorDocImcsSt = valorDocImcsSt;
    }


    public String getCnpjEmissor() {
        return cnpjEmissor;
    }

    public void setCnpjEmissor(String cnpjEmissor) {
        this.cnpjEmissor = cnpjEmissor;
    }

    public BigDecimal getValorEfd() {
        return valorEfd;
    }

    public void setValorEfd(BigDecimal valorEfd) {
        this.valorEfd = valorEfd;
    }

    public BigDecimal getValorDoc() {
        return valorDoc;
    }

    public void setValorDoc(BigDecimal valorDoc) {
        this.valorDoc = valorDoc;
    }

    public String getChaveDoc() {
        return chaveDoc;
    }

    public void setChaveDoc(String chaveDoc) {
        this.chaveDoc = chaveDoc;
    }

    public Integer getAnoMes() {
        return anoMes;
    }

    public void setAnoMes(Integer anoMes) {
        this.anoMes = anoMes;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    
}
