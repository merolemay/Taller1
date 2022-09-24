package co.edu.icesi.ecozoo.error;

import co.edu.icesi.ecozoo.error.exception.AnimalError;
import co.edu.icesi.ecozoo.error.exception.AnimalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AnimalError> handleException(AnimalException animalException){
        return new ResponseEntity<>(animalException.getError(), animalException.getHttpStatus());
    }

}
