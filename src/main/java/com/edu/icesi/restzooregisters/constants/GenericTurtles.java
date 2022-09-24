package com.edu.icesi.restzooregisters.constants;

import com.edu.icesi.restzooregisters.dto.AnimalDTO;

import java.util.UUID;

public class GenericTurtles {
    public final static UUID GENERIC_FEMALE_ID = UUID.nameUUIDFromBytes("femaleGenericId".getBytes());
    ;
    public final static UUID GENERIC_MALE_ID = UUID.nameUUIDFromBytes("maleGenericId".getBytes());
    public final static AnimalDTO GENERIC_MALE_ANIMAL_DTO = new AnimalDTO();
}
