package co.edu.icesi.zoo.error.exception;

import co.edu.icesi.zoo.constant.TatabroErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TatabroError {

    private TatabroErrorCode code;
    private String message;
}