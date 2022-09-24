package co.edu.icesi.ecozoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private UUID id;

    @NotNull(message = "El nombre del animal no puede ser nulo")
    @Size(min = 1, max = 120, message = "El nombre del animal debe tener entre 1 y 120 caracteres")
    @Pattern(regexp = "[a-zA-Z]+\\w*[a-zA-Z]+", message = "El nombre del animal debe contener solo letras y espacios")
    private String name;

    @NotNull(message = "La especie del animal no puede ser nula")
    private boolean sex;

    private Double weight;

    @NotNull(message = "La edad del animal no puede ser nula")
    private int age;

    private Double height;

    @NotNull(message = "La fecha de llegada del animal no puede ser nula")
    @PastOrPresent(message = "La fecha de llegada del animal debe ser anterior o igual a la fecha actual")
    private LocalDateTime arrivalDate;

    private UUID motherID;

    private UUID fatherID;
}
