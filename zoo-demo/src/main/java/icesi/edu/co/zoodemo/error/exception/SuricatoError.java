package icesi.edu.co.zoodemo.error.exception;

import icesi.edu.co.zoodemo.constant.SuricatoErrorsCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuricatoError {

    private SuricatoErrorsCode code;
    private String message;

}
