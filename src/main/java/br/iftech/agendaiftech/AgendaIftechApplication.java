package br.iftech.agendaiftech;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Aplicação IFTech", version = "1.0", description = "Aplicação exemplo Rest API"))
public class AgendaIftechApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaIftechApplication.class, args);
	}

}
