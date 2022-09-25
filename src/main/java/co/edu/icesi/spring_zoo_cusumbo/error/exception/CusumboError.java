package co.edu.icesi.spring_zoo_cusumbo.error.exception;

import co.edu.icesi.spring_zoo_cusumbo.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CusumboError {

    private String message;

    private ErrorCode errorCode;

}
