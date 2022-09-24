package com.edu.icesi.CaliZoo.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToucanError {
    private String code;
    private String message;
}//End ToucanError
