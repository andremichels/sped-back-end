/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.api.resource;

import br.com.sped.scf.model.entity.docnaoescriturado.DocNaoEscriturado;
import br.com.sped.scf.service.docnaoescriturado.DocNaoEscrituradoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dário
 */
@RestController
@RequestMapping("/api/consulta-doc-naoescriturado-contribuinte")
public class ConsultarDocNaoEscrituradoPorContrResource {

    @Autowired
    DocNaoEscrituradoService docNaoEscrituradoService;
    
        @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity consultar(
			@RequestParam(value = "cnpj", required = true) String cnpj,
                        @RequestParam(value = "ano", required = true) String ano,
                        @RequestParam(value = "mes", required = true) String mes
	) {

		try {
                    Integer anoMes =  Integer.parseInt(ano + mes); 
                    List<DocNaoEscriturado>  docNaoEscrituradoList = docNaoEscrituradoService.consultarPorCnpjEmissorAndAnoMes(cnpj, anoMes);

                    if(docNaoEscrituradoList.isEmpty())
                        return ResponseEntity.badRequest().body("Não foram encontrados registros para este Período");

                    return ResponseEntity.ok(docNaoEscrituradoList);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro ao consultar");
		}
	}

    
}
