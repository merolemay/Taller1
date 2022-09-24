package com.edu.icesi.conceptsreview.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class AnimalException extends RuntimeException {

    private HttpStatus httpStatus;
    private AnimalError error;

}
