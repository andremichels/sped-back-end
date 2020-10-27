/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.repository.docnaoescriturado;


import br.com.sped.scf.model.entity.docnaoescriturado.DocNaoEscriturado;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 711541241
 */
public interface DocNaoEscrituradoRepository extends MongoRepository<DocNaoEscriturado, String> {

    public List<DocNaoEscriturado> findByCnpjEmissorAndAnoMes(String cnpjEmissor, Integer anoMes);   
}
