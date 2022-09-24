package co.edu.icesi.ecozoo.error.exception;

import co.edu.icesi.ecozoo.constant.AnimalErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalError {
    private AnimalErrorCode code;
    private String message;
}
