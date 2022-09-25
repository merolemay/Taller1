package co.icesi.edu.animals.dto;

import co.icesi.edu.animals.model.Caripiare;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaripiareAndParentsDTO {

    private UUID id;

    private String name;

    private char gender;

    private double weight;

    private int age;

    private double height;

    private LocalDate arrivalDate;

    private Caripiare father;

    private Caripiare mother;
}
