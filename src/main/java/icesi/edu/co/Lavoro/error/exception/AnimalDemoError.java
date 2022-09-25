package icesi.edu.co.Lavoro.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalDemoError {
    private String code;
    private String message;
}
