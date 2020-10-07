/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.api.resource;


import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import br.com.sped.scf.service.divergenciaDocFiscal.DivergenciaDocFiscalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/consulta-doc-divergente-contribuinte")
public class ConsultarDocDivergentePorContrResource {

	@Autowired
        DivergenciaDocFiscalService divergenciaDocFiscalService;
    
	@GetMapping
	public ResponseEntity consultar(
			@RequestParam(value = "cnpj", required = true) String cnpj,
                        @RequestParam(value = "ano", required = true) String ano,
                        @RequestParam(value = "mes", required = true) String mes
	) {
		System.out.print("ConsultarDocDivergentePorContrResource ENTROU");

		try {
                    Integer anoMes =  Integer.parseInt(ano + mes); 
                    List<DivergenciaDocFiscal>  divergenciaDocFiscalList = divergenciaDocFiscalService.consultarPorCnpjEmissorAndAnoMes(cnpj, anoMes);

                    if(divergenciaDocFiscalList.isEmpty())
                        return ResponseEntity.badRequest().body("Não foram encontrados registros para este Período");

                    return ResponseEntity.ok(divergenciaDocFiscalList);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro ao consultar");
		}

//		System.out.print("quantidade:"+listTotalizadorParcelamentoDTO.size());

	}
	
	
}
