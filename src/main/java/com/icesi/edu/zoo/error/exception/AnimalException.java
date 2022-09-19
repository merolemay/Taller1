package com.icesi.edu.zoo.error.exception;

import org.springframework.http.HttpStatus;

public class AnimalException extends RuntimeException {

    private HttpStatus httpStatus;
    private AnimalError animalError;

}
