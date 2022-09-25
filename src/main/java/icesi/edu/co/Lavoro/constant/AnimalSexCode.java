package icesi.edu.co.Lavoro.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalSexCode {
    FEMALE(true),
    MALE(false);
    private final boolean value;
}
