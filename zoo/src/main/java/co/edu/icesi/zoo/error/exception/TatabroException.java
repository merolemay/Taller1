package co.edu.icesi.zoo.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class TatabroException extends RuntimeException {

    private HttpStatus httpStatus;
    private TatabroError error;
}