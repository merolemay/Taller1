package co.edu.icesi.zoo.service.impl;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.mapper.AnimalMapper;
import co.edu.icesi.zoo.model.Animal;
import co.edu.icesi.zoo.repository.AnimalRepository;
import co.edu.icesi.zoo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public String getNameFromUUID(UUID animal) {
        return Optional.ofNullable(getAnimal(animal)).map(Animal::getName).orElse(null);
    }

    @Override
    public UUID getUUIDFromName(String animalName) {
        return Optional.ofNullable(getAnimal(animalName)).map(Animal::getId).orElse(null);
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal getAnimal(String animalName) {
        return animalRepository.findByName(animalName).orElse(null);
    }

    @Override
    public AnimalDTO getDTOFromAnimal(Animal animal) {
        return (animal == null) ? null : animalMapper.fromAnimalToDTO(animal, getNameFromUUID(animal.getFather_id()), getNameFromUUID(animal.getMother_id()));
    }

    @Override
    public Animal getAnimalFromDTO(AnimalDTO animalDTO) {
        return (animalDTO == null) ? null : animalMapper.fromDTOToAnimal(animalDTO, getUUIDFromName(animalDTO.getFather()), getUUIDFromName(animalDTO.getMother()));
    }

    @Override
    public AnimalWithParentsDTO getAnimalWithParentsFromAnimal(Animal animal) {
        if (animal == null)
            return null;
        AnimalDTO father = (animal.getFather_id() == null) ? null : getDTOFromAnimal(getAnimal(animal.getFather_id()));
        AnimalDTO mother = (animal.getMother_id() == null) ? null : getDTOFromAnimal(getAnimal(animal.getMother_id()));
        return animalMapper.fromAnimalToAnimalWithParentsDTO(animal, father, mother);
    }

    @Override
    public Animal getAnimal(@Nullable UUID id) {
        return (id == null) ? null : animalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
