package com.edu.icesi.conceptsreview.mapper;


import com.edu.icesi.conceptsreview.dto.AnimalDTO;
import com.edu.icesi.conceptsreview.dto.AnimalParentsDTO;
import com.edu.icesi.conceptsreview.dto.AnimalParentsObjectDTO;
import com.edu.icesi.conceptsreview.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    Animal fromAnimalDTOtoAnimal(AnimalDTO animalDTO);
    AnimalDTO fromAnimalToAnimalDTO(Animal animal);
    Animal fromAnimalParentsDTOtoAnimal(AnimalParentsDTO animalParentsDTO);
    AnimalParentsDTO fromAnimalToAnimalParentsDTO(Animal animal);
    AnimalParentsObjectDTO fromAnimalParentsDTOtoAnimalParentsObjectDTO(AnimalParentsDTO animalParentsDTODTO);
    AnimalParentsObjectDTO fromAnimalToAnimalParentsObjectDTO(Animal animal);
}
