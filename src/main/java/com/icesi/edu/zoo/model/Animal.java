package com.icesi.edu.zoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Table(name = "`animal`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID maleParent;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID femaleParent;

    private boolean sex;

    private double weight;

    private int age;

    private double height;

    private Date arrivalDate;

}
