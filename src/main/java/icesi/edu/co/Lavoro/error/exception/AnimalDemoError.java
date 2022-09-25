package icesi.edu.co.Lavoro.error.exception;

import icesi.edu.co.Lavoro.constant.AnimalErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalDemoError {
    private AnimalErrorCode code;
    private String message;
}
