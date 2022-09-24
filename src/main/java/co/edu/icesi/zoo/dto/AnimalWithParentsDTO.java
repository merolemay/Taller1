package co.edu.icesi.zoo.dto;

import co.edu.icesi.zoo.constant.AnimalGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalWithParentsDTO {

    private String name;
    private AnimalGender sex;
    private int age;
    private double height;
    private double weight;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;
    private AnimalDTO father;
    private AnimalDTO mother;
}
