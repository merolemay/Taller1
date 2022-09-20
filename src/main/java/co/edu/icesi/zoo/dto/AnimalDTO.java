package co.edu.icesi.zoo.dto;

import co.edu.icesi.zoo.constant.AnimalGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private String name;
    private AnimalGender sex;
    private int age;
    private double height;
    private double weight;
    private Date arrivalDate;
    private String father;
    private String mother;
}
