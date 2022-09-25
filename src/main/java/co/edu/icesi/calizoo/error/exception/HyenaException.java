package co.edu.icesi.calizoo.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class HyenaException extends RuntimeException{
    private HttpStatus httpStatus;
    private HyenaError error;

}
