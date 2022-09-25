package co.edu.icesi.zoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TatabroErrorCode {

    CODE_01("Tatabro ID doesn't exist."),
    CODE_02("Tatabro's name doesn't exist."),
    CODE_03("Tatabro's name already exists."),
    CODE_04("Tatabro's father must be a male and tatabro's mother must be a female."),
    UNIVERSAL_ANNOTATION_CODE("Method argument not valid.");

    private final String message;
}