/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.service.docnaoescriturado;

import br.com.sped.scf.model.entity.docnaoescriturado.DocNaoEscriturado;
import br.com.sped.scf.model.repository.docnaoescriturado.DocNaoEscrituradoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 711541241
 */
@Service
public class DocNaoEscrituradoServiceImpl implements  DocNaoEscrituradoService{

    DocNaoEscrituradoRepository  repository;

    public DocNaoEscrituradoServiceImpl(DocNaoEscrituradoRepository  repository){
        super();
        this.repository = repository;
    }

    @Override
    public List<DocNaoEscriturado> consultarPorCnpjEmissorAndAnoMes(String cnpjEmissor, Integer anoMes) {
        return repository.findByCnpjEmissorAndAnoMes(cnpjEmissor, anoMes);
    }
    
}
