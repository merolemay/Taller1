package co.edu.icesi.ostrich_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("co.edu.icesi.ostrich_log.mapper.OstrichMapper")
public class OstrichLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OstrichLogApplication.class, args);
	}

}
