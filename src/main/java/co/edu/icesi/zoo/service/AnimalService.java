package co.edu.icesi.zoo.service;

import co.edu.icesi.zoo.model.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

    Animal createAnimal(Animal animal);
    Animal getAnimal(String animalName);
    Optional<Animal> getNullableAnimal(String animalName);
    List<Animal> getAnimals();
}
