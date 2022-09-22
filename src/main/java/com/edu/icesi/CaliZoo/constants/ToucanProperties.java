package com.edu.icesi.CaliZoo.constants;

public enum ToucanProperties {

    MAX_WEIGHT(680), MIN_WEIGHT(130),
    MAX_HEIGHT(65), MIN_HEIGHT(18),
    MAX_AGE(20), MIN_AGE(0);

    private double value;

    private ToucanProperties(double value){
        this.value = value;
    }//End ToucanProperties

    public double getValue(){
        return value;
    }//End getMaxValue

}//End ToucanProperties
