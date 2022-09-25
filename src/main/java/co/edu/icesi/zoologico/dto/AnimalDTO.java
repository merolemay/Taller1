package co.edu.icesi.zoologico.dto;

import co.edu.icesi.zoologico.config.jackson.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AnimalDTO{
    private UUID id;

    private String name;
    private String gender;
    private Integer weight;
    private Integer age;
    private Integer height;
    private UUID mother;
    private UUID father;

    private LocalDateTime arrivalDate;


}
