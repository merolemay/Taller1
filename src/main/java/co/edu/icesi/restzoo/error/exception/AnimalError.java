package co.edu.icesi.restzoo.error.exception;

import co.edu.icesi.restzoo.constant.AnimalErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalError {
    private AnimalErrorCode code;
    private String message;
}
