package co.edu.icesi.ecozoo.service;

import co.edu.icesi.ecozoo.model.Animal;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    public Animal getAnimal(UUID animalId);

    public Animal getAnimalByName(String name);

    public Animal createAnimal(Animal animal);

    public List<Animal> getAnimals();
}
