package co.edu.icesi.zoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Jabiru {

    WEIGHT(4, 9),
    AGE(0, 35),
    HEIGHT(120, 150);

    private final float min, max;

}
