package co.edu.icesi.ecozoo.dto;

import co.edu.icesi.ecozoo.constant.CapybaraConstraints;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapybaraDTO extends AnimalDTO{

    @DecimalMax(value = CapybaraConstraints.MAX_WEIGHT, message = "El peso del animal debe ser menor o igual a " + CapybaraConstraints.MAX_WEIGHT)
    @DecimalMin(value = CapybaraConstraints.MIN_WEIGHT, message = "El peso del animal debe ser mayor o igual a " + CapybaraConstraints.MIN_WEIGHT)
    private Double weight;

    @Range(min = CapybaraConstraints.MIN_AGE, max = CapybaraConstraints.MAX_AGE, message = "La edad del animal debe ser mayor o igual a " + CapybaraConstraints.MIN_AGE + " y menor o igual a " + CapybaraConstraints.MAX_AGE)
    private int age;

    @DecimalMax(value = CapybaraConstraints.MAX_HEIGHT, message = "La altura del animal debe ser menor o igual a " + CapybaraConstraints.MAX_HEIGHT)
    @DecimalMin(value = CapybaraConstraints.MIN_HEIGHT, message = "La altura del animal debe ser mayor o igual a " + CapybaraConstraints.MIN_HEIGHT)
    private Double height;
}
