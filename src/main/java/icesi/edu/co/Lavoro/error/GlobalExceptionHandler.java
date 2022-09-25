package icesi.edu.co.Lavoro.error;

import icesi.edu.co.Lavoro.error.exception.AnimalDemoError;
import icesi.edu.co.Lavoro.error.exception.AnimalDemoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AnimalDemoError> handleException(AnimalDemoException userDemoException){
        return new ResponseEntity<>(userDemoException.getError(), userDemoException.getHttpStatus());
    }
}
