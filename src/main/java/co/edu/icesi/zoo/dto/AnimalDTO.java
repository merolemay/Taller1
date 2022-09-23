package co.edu.icesi.zoo.dto;

import co.edu.icesi.zoo.constant.AnimalGender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
