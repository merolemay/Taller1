package co.edu.icesi.zoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalErrorCode {

    CODE_01("All fields are required except father's and mother's animal"),
    CODE_02("The field father need to be a male"),
    CODE_03("The field mother need to be a female"),
    CODE_04("The name cannot be greater than 120 characters"),
    CODE_05("Animal father or mother does not exists"),
    CODE_06("Animal name should contain only letters and spaces"),
    CODE_07("The weight of the animal is not realistic"),
    CODE_08("The height of the animal is not realistic");

    private final String message;
}
