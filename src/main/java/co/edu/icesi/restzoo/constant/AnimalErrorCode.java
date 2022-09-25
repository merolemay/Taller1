package co.edu.icesi.restzoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalErrorCode {

    DEF_E0x00("Empty error."),
    SER_E0x01("Requested name is taken by other specimen within Zoo."),
    SER_E0x02_1("Father UUID not found."),
    SER_E0x02_2("Mother UUID not found."),
    SER_E0x02_3("Request contains only one parent, but two are required."),
    SER_E0x03("Parent's sex incoherent with parental role. Agree 'Mother' with 'F' and 'Father' with 'M'  (Case insensitive)."),
    SER_E0x04("Requested arrival date should be in the past, but is in the future instead."),
    CRL_E0x11("Requested name breaks valid format. Only use letters and spaces."),
    CRL_E0x12("Requested name exceeds 120 character limit."),
    CRL_E0x13("Character representing sex is not valid. Should be 'F' or 'M' (Case insensitive)."),
    CRL_E0x14(Constants.MAX_LONGEVITY.validationMessage),
    CRL_E0x15_1(Constants.MIN_HEALTHY_WEIGHT.validationMessage),
    CRL_E0x15_2(Constants.MAX_HEALTHY_WEIGHT.validationMessage),
    CRL_E0x16_1(Constants.MIN_BABY_LENGTH.validationMessage),
    CRL_E0x16_2(Constants.MAX_ELDER_LENGTH.validationMessage);

    private final String message;
}
