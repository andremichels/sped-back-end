/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.service.docnaoescriturado;


import br.com.sped.scf.model.entity.docnaoescriturado.DocNaoEscriturado;
import java.util.List;

/**
 *
 * @author 711541241
 */
public interface DocNaoEscrituradoService {
        public List<DocNaoEscriturado> consultarPorCnpjEmissorAndAnoMes(String cnpjEmissor, Integer anoMes);
}
