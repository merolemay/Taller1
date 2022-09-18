package co.edu.icesi.zoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalGender {
    F("Female"),
    M("Male");

    private final String message;
}
