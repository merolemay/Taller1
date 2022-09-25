package icesi.edu.co.zoodemo.error;

import icesi.edu.co.zoodemo.error.exception.SuricatoError;
import icesi.edu.co.zoodemo.error.exception.SuricatoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SuricatoError> handleException(SuricatoException suricatoException){
        return new ResponseEntity<>(suricatoException.getError(), suricatoException.getHttpStatus());
    }
}
