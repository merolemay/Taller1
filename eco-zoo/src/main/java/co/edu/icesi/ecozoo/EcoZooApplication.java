package co.edu.icesi.ecozoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EcoZooApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoZooApplication.class, args);
    }

}
