package com.edu.icesi.conceptsreview.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalsErrorCodes {

    CODE_01("The name length exceeds the maximum allowed"),
    CODE_02("This animal id doesn't exist"),
    CODE_03("This animal name already exist"),
    CODE_04("Animal wrong genre"),
    CODE_05("The name must contain only letters and spaces"),
    CODE_06("The arrive date cannot be before the actual date"),
    CODE_07("The weight must be between the standards (Kg) 7 - 12"),
    CODE_08("The length/height must be between the standards (Cm) 57 - 95");

    private String message;
}
