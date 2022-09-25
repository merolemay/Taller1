package co.edu.icesi.zoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import liquibase.integration.spring.SpringLiquibase;
import javax.sql.DataSource;

@Configuration
public class LiquidBaseConfig {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}