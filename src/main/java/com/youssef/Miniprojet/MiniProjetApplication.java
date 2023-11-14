package com.youssef.Miniprojet;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import com.youssef.Miniprojet.entities.Marque;
import com.youssef.Miniprojet.entities.Voiture;

@SpringBootApplication
public class MiniProjetApplication {
	@Autowired
private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(MiniProjetApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}


}
