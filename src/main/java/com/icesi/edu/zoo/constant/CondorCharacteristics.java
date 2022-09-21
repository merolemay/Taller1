package com.icesi.edu.zoo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CondorCharacteristics {

    WEIGHT(9, 15),
    HEIGHT(100, 130);

    private double min, max;

}
