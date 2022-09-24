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

    @NotNull
    @Size(min = 1, max = 120)
    @Pattern(regexp = "[a-zA-Z]+\\w*[a-zA-Z]+")
    private String name;

    @NotNull
    private boolean sex;

    private Double weight;

    @NotNull
    private int age;

    private Double height;

    @NotNull
    @PastOrPresent
    private LocalDateTime arrivalDate;

    @Valid
    private UUID motherId;

    @Valid
    private UUID fatherId;
}
