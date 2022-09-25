package co.edu.icesi.apizoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private UUID ID;
    private String name;
    private String sex;
    private Double weight;
    private Integer age;
    private Double height;
    private LocalDateTime arrivalDate;
    private UUID fatherID;
    private UUID motherID;
}
