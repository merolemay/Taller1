package co.edu.icesi.zoo.mapper;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.model.Animal;
import org.mapstruct.Mapper;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal fromDTOToAnimal(AnimalDTO animalDTO, @Nullable UUID father_id, @Nullable UUID mother_id);

    AnimalDTO fromAnimalToDTO(Animal animal, @Nullable String father_name, @Nullable String mother_name);

    AnimalWithParentsDTO fromAnimalToAnimalWithParentsDTO(Animal animal, @Nullable AnimalDTO father, @Nullable AnimalDTO mother);
}
