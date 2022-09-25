package co.edu.icesi.apizoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ApiZooApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiZooApplication.class, args);
	}
}
