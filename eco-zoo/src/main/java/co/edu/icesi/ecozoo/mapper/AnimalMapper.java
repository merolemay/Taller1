package co.edu.icesi.ecozoo.mapper;

import co.edu.icesi.ecozoo.dto.AnimalDTO;
import co.edu.icesi.ecozoo.dto.CapybaraDTO;
import co.edu.icesi.ecozoo.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal fromDTO(AnimalDTO userDTO);

    AnimalDTO fromUser(Animal user);

    CapybaraDTO animalToCapybara(Animal animal);

    Animal capybaraToAnimal(CapybaraDTO capybaraDTO);

}