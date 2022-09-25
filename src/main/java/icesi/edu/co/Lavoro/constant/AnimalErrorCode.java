package icesi.edu.co.Lavoro.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalErrorCode {

    CODE_UD_01("Invalid arguments"),
    CODE_UD_02("Animal parent's id's were not found"),
    CODE_UD_03("Animal mother must be female sex"),
    CODE_UD_04("Animal father must be male sex"),
    CODE_UD_05("Animal doesn't exist on the database"),
    CODE_UD_06("Animal exist on the database");
    private String message;
}
