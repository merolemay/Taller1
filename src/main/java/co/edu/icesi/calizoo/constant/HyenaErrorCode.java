package co.edu.icesi.calizoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HyenaErrorCode {

        CODE_01("Name should contains only letters and spaces. It should be between 1 and 120 characters long"),
        CODE_02("The arrival date should be before the current date"),
        CODE_03("Age should be between 1 and 25 years old according to hyenas aging. Please refer to wikipedia for more information"),
        CODE_04("Weight should be between 1 and 64 kg (kilograms according to hyenas weighting. Please refer to wikipedia for more information"),
        CODE_05("Height should be between 1 and 92 cm (centimeters) according to hyenas general height. Please refer to wikipedia for more information"),
        CODE_06("Father gender should be male"),
        CODE_07("Mother gender should be female"),
        CODE_08("Name is already taken");

        private String message;
}
