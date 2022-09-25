package co.edu.icesi.Zootopia.service;

import co.edu.icesi.Zootopia.model.Animal;

import java.util.List;
import java.util.UUID;

public interface AnimalService {
    public Animal getAnimalUsingName(String name);
    public Animal getAnimalUsingId( UUID id);

    public Animal createAnimal( Animal animalDTO);

    public List<Animal> getAnimals();
}
