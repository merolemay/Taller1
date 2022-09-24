package com.edu.icesi.conceptsreview.error.exception;

import com.edu.icesi.conceptsreview.constant.AnimalsErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalError {

    private AnimalsErrorCodes code;
    private String message;

}
