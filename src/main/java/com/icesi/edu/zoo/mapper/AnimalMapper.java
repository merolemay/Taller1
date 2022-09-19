package com.icesi.edu.zoo.mapper;

import com.icesi.edu.zoo.dto.AnimalDTO;
import com.icesi.edu.zoo.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal fromDTO(AnimalDTO animalDTO);

    AnimalDTO fromAnimal(Animal animal);

}
