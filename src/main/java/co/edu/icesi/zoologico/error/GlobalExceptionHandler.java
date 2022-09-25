package co.edu.icesi.zoologico.error;

import co.edu.icesi.zoologico.error.exception.AnimalDemoError;
import co.edu.icesi.zoologico.error.exception.AnimalDemoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Va a interceptar el llamado de los controladores
public class GlobalExceptionHandler {

    @ExceptionHandler//Ayuda a manejar excepciones
    public ResponseEntity<AnimalDemoError> handleException(AnimalDemoException userDemoException){
        return new ResponseEntity<>(userDemoException.getError(),userDemoException.getHttpStatus());
    }
}
