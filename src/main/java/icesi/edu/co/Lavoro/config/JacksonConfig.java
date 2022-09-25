package icesi.edu.co.Lavoro.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import icesi.edu.co.Lavoro.config.jackson.LocalDateTimeDeserializer;
import icesi.edu.co.Lavoro.config.jackson.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper(){
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
