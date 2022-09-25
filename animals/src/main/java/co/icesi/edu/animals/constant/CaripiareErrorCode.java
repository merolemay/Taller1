package co.icesi.edu.animals.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CaripiareErrorCode {

    CODE_01("Caripiare not found"),
    CODE_02("Name validation failed"),
    CODE_03("Gender validation failed"),
    CODE_04("Weight validation failed"),
    CODE_05("Age validation failed"),
    CODE_06("Height validation failed"),
    CODE_07("Date validation failed"),
    CODE_08("Name already exists"),
    CODE_09("ParentId validation failed");

    private String message;
}
