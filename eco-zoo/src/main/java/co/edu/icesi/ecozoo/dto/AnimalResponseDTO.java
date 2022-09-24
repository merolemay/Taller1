package co.edu.icesi.ecozoo.dto;

import co.edu.icesi.ecozoo.model.Animal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AnimalResponseDTO {

    private UUID id;

    private String name;

    private boolean sex;

    private Double weight;

    private int age;

    private Double height;

    private LocalDateTime arrivalDate;

    @Valid
    private Animal mother;

    @Valid
    private Animal father;
}
