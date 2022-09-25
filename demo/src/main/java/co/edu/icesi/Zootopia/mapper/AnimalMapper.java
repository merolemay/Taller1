package co.edu.icesi.Zootopia.mapper;

import co.edu.icesi.Zootopia.DTO.AnimalDTO;
import co.edu.icesi.Zootopia.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    Animal fromDTO(AnimalDTO animalDTO);
    AnimalDTO fromAnimal(Animal animal);
}
