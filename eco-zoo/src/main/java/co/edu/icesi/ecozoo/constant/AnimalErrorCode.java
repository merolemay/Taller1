package co.edu.icesi.ecozoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalErrorCode {

    CODE_01("Animal not found"),
    CODE_02("The parents must be different"),
    CODE_03("The parents must have different sex"),
    CODE_04("The name must be unique"),
    CODE_05("An argument is invalid");

    private String message;
}
