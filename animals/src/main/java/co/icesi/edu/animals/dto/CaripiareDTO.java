package co.icesi.edu.animals.dto;

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
public class CaripiareDTO {

    private UUID id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID fatherId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID motherId;

    private char gender;

    private double weight;

    private int age;

    private double height;

    private LocalDate arrivalDate;
}