package co.icesi.edu.animals.error;

import co.icesi.edu.animals.error.exception.CaripiareError;
import co.icesi.edu.animals.error.exception.CaripiareException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CaripiareError> handleException(CaripiareException caripiareException){
        return new ResponseEntity<>(caripiareException.getCaripiareError(),
                caripiareException.getHttpStatus());
    }
}
