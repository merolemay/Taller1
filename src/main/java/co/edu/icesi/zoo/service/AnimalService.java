package co.edu.icesi.zoo.service;

import co.edu.icesi.zoo.model.Animal;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnimalService {

    Animal createAnimal(Animal animal);
    Animal getAnimal(String animalName);
    Animal getAnimal(UUID id);
    List<Animal> getAnimals();
}
