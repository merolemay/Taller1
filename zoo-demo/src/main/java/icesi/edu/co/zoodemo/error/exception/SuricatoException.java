package icesi.edu.co.zoodemo.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class SuricatoException extends RuntimeException{
    private HttpStatus httpStatus;
    private SuricatoError error;
}
