package com.edu.icesi.CaliZoo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    INVALID_FORMAT("Error_01: Invalid format"),
    BAD_DATA("Error_02: Invalid data"),
    NOT_FOUND("Error_03: Resource don't found");
    private String code;
}//End ErrorCodes
