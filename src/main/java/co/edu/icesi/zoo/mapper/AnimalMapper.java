package co.edu.icesi.zoo.mapper;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal fromDTOToAnimal(AnimalDTO animalDTO);

    AnimalDTO fromAnimalToDTO(Animal animal);

    AnimalWithParentsDTO fromAnimalToAnimalWithParentsDTO(Animal animal);
}
