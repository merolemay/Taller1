package co.edu.icesi.calizoo.error;

import co.edu.icesi.calizoo.error.exception.HyenaError;
import co.edu.icesi.calizoo.error.exception.HyenaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HyenaError> handleException(HyenaException hyenaException){
        return new ResponseEntity<>(hyenaException.getError(), hyenaException.getHttpStatus());
    }

}
