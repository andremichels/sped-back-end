package br.com.sped.scf;

import br.com.sped.scf.model.entity.docdivergenciafiscal.DivergenciaDocFiscal;
import br.com.sped.scf.model.repository.docdivergenciafiscal.DivergenciaDocFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class SncFeApiApplication implements WebMvcConfigurer {
	
	public static void main(String[] args){
		SpringApplication.run(SncFeApiApplication.class, args);
	}



}
	
