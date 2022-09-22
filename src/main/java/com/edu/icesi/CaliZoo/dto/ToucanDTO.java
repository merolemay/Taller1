package com.edu.icesi.CaliZoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToucanDTO {

    private UUID id;
    private UUID fatherId;
    private UUID motherId;
    private String name;
    private String sex;
    private double weight;
    private int age;
    private double height;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfArrival;

}//End ToucanDTO
