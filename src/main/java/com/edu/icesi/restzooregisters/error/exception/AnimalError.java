package com.edu.icesi.restzooregisters.error.exception;

import com.edu.icesi.restzooregisters.constants.AnimalErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalError {
    private AnimalErrorCode code;
    private String message;
}