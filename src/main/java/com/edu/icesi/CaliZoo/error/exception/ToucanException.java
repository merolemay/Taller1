package com.edu.icesi.CaliZoo.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ToucanException extends RuntimeException{
    private HttpStatus httpStatus;
    private ToucanError error;
}//End ToucanException
