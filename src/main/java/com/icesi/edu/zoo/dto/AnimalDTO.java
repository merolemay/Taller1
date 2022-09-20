package com.icesi.edu.zoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private UUID id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID maleParentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID femaleParentId;

    private char sex;

    private double weight;

    private int age;

    private double height;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date arrivalDate;

}
