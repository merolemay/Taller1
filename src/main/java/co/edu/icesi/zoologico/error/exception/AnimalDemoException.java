package co.edu.icesi.zoologico.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class AnimalDemoException extends RuntimeException {

    private HttpStatus httpStatus;
    private AnimalDemoError error;
}
