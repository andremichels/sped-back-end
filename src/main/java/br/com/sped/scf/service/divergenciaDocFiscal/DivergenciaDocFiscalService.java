/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.service.divergenciaDocFiscal;

import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import java.util.List;

/**
 *
 * @author dario
 */
public interface DivergenciaDocFiscalService {

    public List<DivergenciaDocFiscal> consultarPorCnpjEmissorAndAnoMes(String cnpjEmissor, Integer anoMes);

}
