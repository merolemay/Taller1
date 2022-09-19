package com.icesi.edu.zoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private String id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String maleParent;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String femaleParent;

    private String sex;

    private String weight;

    private int age;

    private String height;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date arrivalDate;

}
