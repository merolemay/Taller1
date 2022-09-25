package co.edu.icesi.zoo.error;

import co.edu.icesi.zoo.constant.TatabroErrorCode;
import co.edu.icesi.zoo.error.exception.TatabroError;
import co.edu.icesi.zoo.error.exception.TatabroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TatabroError> handleException(TatabroException tatabroException) {
        return new ResponseEntity<>(tatabroException.getError(), tatabroException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<TatabroError> handleException(MethodArgumentNotValidException methodArgumentNotValidException) {
        TatabroException tatabroException = new TatabroException(HttpStatus.BAD_REQUEST, new TatabroError(TatabroErrorCode.UNIVERSAL_ANNOTATION_CODE, Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage()));
        return new ResponseEntity<>(tatabroException.getError(), tatabroException.getHttpStatus());
    }
}