package co.edu.icesi.ecozoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalSex {
    FEMALE(true),
    MALE(false);

    private final boolean value;
}
