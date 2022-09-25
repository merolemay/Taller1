package icesi.edu.co.Lavoro.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class AnimalDemoException extends RuntimeException {
    private HttpStatus httpStatus;
    private AnimalDemoError error;
}
