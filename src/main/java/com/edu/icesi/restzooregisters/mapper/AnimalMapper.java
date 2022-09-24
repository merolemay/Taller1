package com.edu.icesi.restzooregisters.mapper;

import com.edu.icesi.restzooregisters.dto.AnimalDTO;
import com.edu.icesi.restzooregisters.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    Animal fromDTO(AnimalDTO animalDTO);
    AnimalDTO fromAnimal(Animal user);
}
