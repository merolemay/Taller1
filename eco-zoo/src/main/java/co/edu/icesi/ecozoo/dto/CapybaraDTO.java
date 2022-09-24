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

    @DecimalMax(value = CapybaraConstraints.MAX_WEIGHT)
    @DecimalMin(value = CapybaraConstraints.MIN_WEIGHT)
    private Double weight;

    @Range(min = CapybaraConstraints.MIN_AGE, max = CapybaraConstraints.MAX_AGE)
    private int age;

    @DecimalMax(value = CapybaraConstraints.MAX_HEIGHT)
    @DecimalMin(value = CapybaraConstraints.MIN_HEIGHT)
    private Double height;
}
