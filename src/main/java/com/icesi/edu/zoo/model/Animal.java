package com.icesi.edu.zoo.model;

import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

public class Animal {

    @Id
    private UUID id;

    private String name;

    private UUID maleParent;

    private UUID femaleParent;

    private boolean sex;

    private double weight;

    private int age;

    private double height;

    private Date arrivalDate;

}
