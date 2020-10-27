/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.api.resource;

import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import br.com.sped.scf.model.entity.docnaoescriturado.DocNaoEscriturado;
import br.com.sped.scf.service.docnaoescriturado.DocNaoEscrituradoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "DOCUMENTOS FISCAIS DE UM CONTRIBUINTE NÃO ESCRITURADOS(NF-E,CT-E)", notes = "Lista com todos os documentos não escriturados do mês", response = DocNaoEscriturado.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Documentos Listados com sucesso"),

        @ApiResponse(code = 404, message = "Documentos não encontrados para o Período")})
    
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultar(
            @ApiParam( required = true, value = "CNPJ sem zero à esquerda")
            @RequestParam(value = "cnpj", required = true) String cnpj,
            @ApiParam( required = true, value = "Ano com 4 digitos")
            @RequestParam(value = "ano", required = true) String ano,
            @ApiParam( required = true, value = "Mês com 2 digitos")
            @RequestParam(value = "mes", required = true) String mes
    ) {

        try {
            Integer anoMes = Integer.parseInt(ano + mes);
            List<DocNaoEscriturado> docNaoEscrituradoList = docNaoEscrituradoService.consultarPorCnpjEmissorAndAnoMes(cnpj, anoMes);

            if (docNaoEscrituradoList.isEmpty()) {
                return ResponseEntity.badRequest().body("Não foram encontrados registros para este Período");
            }

            return ResponseEntity.ok(docNaoEscrituradoList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao consultar");
        }
    }

}
