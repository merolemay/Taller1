package co.edu.icesi.calizoo.error.exception;

import co.edu.icesi.calizoo.constant.HyenaErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HyenaError {
    private HyenaErrorCode code;
    private String message;
}
