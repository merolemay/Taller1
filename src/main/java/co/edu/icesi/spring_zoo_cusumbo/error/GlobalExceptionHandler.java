package co.edu.icesi.spring_zoo_cusumbo.error;

import co.edu.icesi.spring_zoo_cusumbo.error.exception.CusumboError;
import co.edu.icesi.spring_zoo_cusumbo.error.exception.CusumboException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CusumboError> handleException(CusumboException cusumboException){
        return new ResponseEntity<>(cusumboException.getError(), cusumboException.getHttpStatus());
    }

}
