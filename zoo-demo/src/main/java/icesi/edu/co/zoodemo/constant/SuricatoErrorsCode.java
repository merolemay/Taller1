package icesi.edu.co.zoodemo.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuricatoErrorsCode {
    CODE_01("The length of the name exceeds the established characters"),
    CODE_02("Meerkat id not found"),
    CODE_03("The name of this meerkat is already entered"),
    CODE_04("Wrong genre"),
    CODE_05("Invalid characters"),
    CODE_06("Invalid date"),
    CODE_07("The weight must be between 400 - 850 (g) "),
    CODE_08("The height must be between 25 - 35 (Cm)");
    private String message;
}
