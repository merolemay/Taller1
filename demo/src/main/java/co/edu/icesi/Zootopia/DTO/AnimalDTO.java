package co.edu.icesi.Zootopia.DTO;


import co.edu.icesi.Zootopia.constant.AnimalConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private UUID id;
    private UUID fatherId;
    private UUID motherId;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z ]+", message = "WTF!? What kind of name does it have?")
    @Size(min = 1, max=120)
    private String name;

    @NotNull
    @Pattern(regexp = "[MnFf]", message = "We only accept (M or m) for male and (F or f) for female")
    private String sex;

    @DecimalMin(value = AnimalConstant.ANACONDA_LOWER_BOUND_WEIGHT + "", message = "Sorry it's too lightweight")
    @DecimalMax(value = AnimalConstant.ANACONDA_UPPER_BOUND_WEIGHT + "", message = "It's too heavy")
    private float weight;

    @DecimalMax(value = AnimalConstant.ANACONDA_UPPER_BOUND_AGE + "", message = "Sorry bro, actually it's not alive")
    @DecimalMin(value = AnimalConstant.ANACONDA_LOWER_BOUND_AGE+"", message = "Please bro, at least let it born")
    private float age;

    @DecimalMin(value = AnimalConstant.ANACONDA_LOWER_BOUND_LENGTH + "", message = "This place is for anacondas, not for worms")
    @DecimalMax(value = AnimalConstant.ANACONDA_UPPER_BOUND_LENGTH + "", message = "What horror movie did you bring that monster?!! ")
    private float height;

    @NotNull
    @PastOrPresent(message = "Ehm, are you any kind of time traveler? sorry we only accept real people")
    private LocalDateTime arrivalDate;

}
