package co.edu.icesi.zoo.dto;

import co.edu.icesi.zoo.constant.AnimalGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalWithParentsDTO {

    private String name;
    private AnimalGender sex;
    private int age;
    private double height;
    private double weight;
    private Date arrivalDate;
    private AnimalDTO father;
    private AnimalDTO mother;
}
