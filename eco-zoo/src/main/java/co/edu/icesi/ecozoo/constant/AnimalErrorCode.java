package co.edu.icesi.ecozoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalErrorCode {

    CODE_01("Animal not found"),
    CODE_02("The parent must exist in the database"),
    CODE_03("The mother must be a female"),
    CODE_04("The father must be a male"),
    CODE_05("The name must be unique"),
    CODE_06("An argument is invalid");

    private final String message;
}
