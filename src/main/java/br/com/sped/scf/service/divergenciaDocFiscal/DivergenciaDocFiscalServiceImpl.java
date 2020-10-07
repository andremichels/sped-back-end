/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.service.divergenciaDocFiscal;

import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import br.com.sped.scf.model.repository.docdivergenciafiscal.DivergenciaDocFiscalRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author dario
 */
@Service
public class DivergenciaDocFiscalServiceImpl implements DivergenciaDocFiscalService {
    
    DivergenciaDocFiscalRepository divergenciaDocFiscalRepository;

    public DivergenciaDocFiscalServiceImpl(DivergenciaDocFiscalRepository divergenciaDocFiscalRepository){
        super();
        this.divergenciaDocFiscalRepository = divergenciaDocFiscalRepository;
    }

    @Override
    public List<DivergenciaDocFiscal> consultarPorCnpjEmissorAndAnoMes(String cnpjEmissor, Integer anoMes) {

        return divergenciaDocFiscalRepository.findByCnpjEmissorAndAnoMes(cnpjEmissor, anoMes);
    }
    
}
