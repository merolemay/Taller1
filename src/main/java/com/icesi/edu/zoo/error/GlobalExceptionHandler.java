package com.icesi.edu.zoo.error;

import com.icesi.edu.zoo.error.exception.AnimalError;
import com.icesi.edu.zoo.error.exception.AnimalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AnimalError> handleException(AnimalException animalException) {
        return new ResponseEntity<>(animalException.getAnimalError(), animalException.getHttpStatus());
    }

}
