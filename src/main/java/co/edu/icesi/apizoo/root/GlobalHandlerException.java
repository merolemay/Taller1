package co.edu.icesi.apizoo.root;


import co.edu.icesi.apizoo.root.exception.ApiZooError;
import co.edu.icesi.apizoo.root.exception.ApiZooException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalHandlerException {

    public ResponseEntity<ApiZooError> handlerException(ApiZooException apiZooException){
        return new ResponseEntity<>(apiZooException.getApiZooError(), apiZooException.getHttpStatus());
    }
}
