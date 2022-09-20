package co.edu.icesi.zoo.mapper.impl;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.mapper.AnimalMapper;
import co.edu.icesi.zoo.model.Animal;
import co.edu.icesi.zoo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AnimalMapperImpl implements AnimalMapper {

    private final AnimalService animalService;

    @Override
    public Animal fromDTOToAnimal(AnimalDTO animalDTO) {
        if (animalDTO == null)
            return null;

        Animal.AnimalBuilder animal = Animal.builder();

        animal.name(animalDTO.getName());
        animal.sex(animalDTO.getSex());
        animal.age(animalDTO.getAge());
        animal.height(animalDTO.getHeight());
        animal.weight(animalDTO.getWeight());
        animal.arrivalDate(animalDTO.getArrivalDate());
        Optional.ofNullable(animalService.getAnimal(animalDTO.getFather())).map(Animal::getId).ifPresent(animal::father_id);
        Optional.ofNullable(animalService.getAnimal(animalDTO.getMother())).map(Animal::getId).ifPresent(animal::mother_id);

        return animal.build();
    }

    @Override
    public AnimalDTO fromAnimalToDTO(Animal animal) {
        if (animal == null)
            return null;

        AnimalDTO.AnimalDTOBuilder animalDTO = AnimalDTO.builder();

        animalDTO.name(animal.getName());
        animalDTO.sex(animal.getSex());
        animalDTO.age(animal.getAge());
        animalDTO.height(animal.getHeight());
        animalDTO.weight(animal.getWeight());
        animalDTO.arrivalDate(animal.getArrivalDate());
        if (Objects.nonNull(animal.getFather_id()))
            Optional.ofNullable(animalService.getAnimal(animal.getFather_id())).map(Animal::getName).ifPresent(animalDTO::father);
        if (Objects.nonNull(animal.getMother_id()))
            Optional.ofNullable(animalService.getAnimal(animal.getMother_id())).map(Animal::getName).ifPresent(animalDTO::mother);

        return animalDTO.build();
    }

    @Override
    public AnimalWithParentsDTO fromAnimalToAnimalWithParentsDTO(Animal animal) {
        if (animal == null)
            return null;

        AnimalWithParentsDTO.AnimalWithParentsDTOBuilder animalWithParentsDTO = AnimalWithParentsDTO.builder();

        animalWithParentsDTO.name(animal.getName());
        animalWithParentsDTO.sex(animal.getSex());
        animalWithParentsDTO.age(animal.getAge());
        animalWithParentsDTO.height(animal.getHeight());
        animalWithParentsDTO.weight(animal.getWeight());
        animalWithParentsDTO.arrivalDate(animal.getArrivalDate());
        if (Objects.nonNull(animal.getFather_id()))
            Optional.ofNullable(fromAnimalToDTO(animalService.getAnimal(animal.getFather_id()))).ifPresent(animalWithParentsDTO::father);
        if (Objects.nonNull(animal.getMother_id()))
            Optional.ofNullable(fromAnimalToDTO(animalService.getAnimal(animal.getMother_id()))).ifPresent(animalWithParentsDTO::mother);

        return animalWithParentsDTO.build();
    }
}
