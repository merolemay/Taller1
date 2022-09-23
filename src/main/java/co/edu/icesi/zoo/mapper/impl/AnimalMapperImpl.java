package co.edu.icesi.zoo.mapper.impl;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.mapper.AnimalMapper;
import co.edu.icesi.zoo.model.Animal;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public Animal fromDTOToAnimal(AnimalDTO animalDTO, @Nullable UUID father_id, @Nullable UUID mother_id) {
        if (animalDTO == null)
            return null;

        Animal.AnimalBuilder animal = Animal.builder();

        animal.name(animalDTO.getName());
        animal.sex(animalDTO.getSex());
        animal.age(animalDTO.getAge());
        animal.height(animalDTO.getHeight());
        animal.weight(animalDTO.getWeight());
        animal.arrivalDate(animalDTO.getArrivalDate());
        animal.father_id(father_id);
        animal.mother_id(mother_id);

        return animal.build();
    }

    @Override
    public AnimalDTO fromAnimalToDTO(Animal animal, @Nullable String father_name, @Nullable String mother_name) {
        if (animal == null)
            return null;

        AnimalDTO.AnimalDTOBuilder animalDTO = AnimalDTO.builder();

        animalDTO.name(animal.getName());
        animalDTO.sex(animal.getSex());
        animalDTO.age(animal.getAge());
        animalDTO.height(animal.getHeight());
        animalDTO.weight(animal.getWeight());
        animalDTO.arrivalDate(animal.getArrivalDate());
        animalDTO.father(father_name);
        animalDTO.mother(mother_name);

        return animalDTO.build();
    }

    @Override
    public AnimalWithParentsDTO fromAnimalToAnimalWithParentsDTO(Animal animal, @Nullable AnimalDTO father, @Nullable AnimalDTO mother) {
        if (animal == null)
            return null;

        AnimalWithParentsDTO.AnimalWithParentsDTOBuilder animalWithParentsDTO = AnimalWithParentsDTO.builder();

        animalWithParentsDTO.name(animal.getName());
        animalWithParentsDTO.sex(animal.getSex());
        animalWithParentsDTO.age(animal.getAge());
        animalWithParentsDTO.height(animal.getHeight());
        animalWithParentsDTO.weight(animal.getWeight());
        animalWithParentsDTO.arrivalDate(animal.getArrivalDate());
        animalWithParentsDTO.father(father);
        animalWithParentsDTO.mother(mother);

        return animalWithParentsDTO.build();
    }
}
