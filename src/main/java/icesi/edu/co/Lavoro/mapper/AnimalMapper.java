package icesi.edu.co.Lavoro.mapper;

import icesi.edu.co.Lavoro.dto.AnimalDTO;
import icesi.edu.co.Lavoro.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal fromDTO(AnimalDTO animalDTO);

    AnimalDTO fromAnimal(Animal animal);

}
