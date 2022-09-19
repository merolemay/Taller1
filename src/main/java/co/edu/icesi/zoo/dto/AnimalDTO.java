package co.edu.icesi.zoo.dto;

import co.edu.icesi.zoo.constant.AnimalGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private UUID id;
    private String name;
    private AnimalGender sex;
    private int age;
    private double height;
    private double weight;
    private Date arrivalDate;
    private UUID father_id;
    private UUID mother_id;
}
