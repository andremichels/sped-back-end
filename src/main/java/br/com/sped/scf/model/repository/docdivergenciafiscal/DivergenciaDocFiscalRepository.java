/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.repository.docdivergenciafiscal;

import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @author dario
 */
public interface  DivergenciaDocFiscalRepository extends MongoRepository<DivergenciaDocFiscal, String> {

  public List<DivergenciaDocFiscal> findByCnpjEmissorAndAnoMes(String cnpjEmissor, Integer anoMes);
   
}
