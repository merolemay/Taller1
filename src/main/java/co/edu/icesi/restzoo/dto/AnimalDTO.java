package co.edu.icesi.restzoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    protected UUID id;

    protected String name;

    protected char sex;

    protected double weight;

    protected double age;

    protected double length;

    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    protected LocalDateTime arrivalDate;

    protected String father;

    protected String mother;
}
