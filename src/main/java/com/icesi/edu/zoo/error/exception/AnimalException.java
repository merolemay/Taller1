package com.icesi.edu.zoo.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class AnimalException extends RuntimeException {

    private HttpStatus httpStatus;
    private AnimalError animalError;

}
