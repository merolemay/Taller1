package co.edu.icesi.restzoo.service;

import co.edu.icesi.restzoo.model.Animal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    Animal getAnimal(@PathVariable UUID animalId);

    Animal getAnimal(@PathVariable String animalName);

    Animal createAnimal(@RequestBody Animal animal);

    List<Animal> getAnimals();
}
