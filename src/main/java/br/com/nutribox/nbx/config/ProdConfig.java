package br.com.nutribox.nbx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sun.el.parser.ParseException;

import br.com.nutribox.nbx.services.DBService;



@Configuration
@Profile("dev")
public class ProdConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() {
		dbService.instantiateTestDatabase();
		return true;
		
	}

	
	
}
