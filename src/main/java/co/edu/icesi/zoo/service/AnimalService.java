package co.edu.icesi.zoo.service;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.model.Animal;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    String getNameFromUUID(UUID animal);

    AnimalDTO getDTOFromAnimal(Animal animal);

    Animal getAnimalFromDTO(AnimalDTO animalDTO);

    AnimalWithParentsDTO getAnimalWithParentsFromAnimal(Animal animal);

    UUID getUUIDFromName(String animalName);

    Animal createAnimal(Animal animal);

    Animal getAnimal(String animalName);

    Animal getAnimal(UUID id);

    List<Animal> getAnimals();
}
