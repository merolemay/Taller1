package com.edu.icesi.restzooregisters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestZooRegistersApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestZooRegistersApplication.class, args);
	}

}
