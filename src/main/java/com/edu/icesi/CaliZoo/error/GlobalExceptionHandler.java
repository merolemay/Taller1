package com.edu.icesi.CaliZoo.error;

import com.edu.icesi.CaliZoo.error.exception.ToucanError;
import com.edu.icesi.CaliZoo.error.exception.ToucanException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ToucanError> handleException(ToucanException toucanException){
        return new ResponseEntity<>(toucanException.getError(),toucanException.getHttpStatus());
    }//End handleException
}//End GlobalExceptionHandler
