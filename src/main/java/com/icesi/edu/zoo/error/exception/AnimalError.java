package com.icesi.edu.zoo.error.exception;

import com.icesi.edu.zoo.constant.AnimalErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalError {

    private String message;
    private AnimalErrorCode code;

}
