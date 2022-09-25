package icesi.edu.co.Lavoro.service;

import icesi.edu.co.Lavoro.model.Animal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    public Animal getAnimal(@PathVariable UUID animalID);

    public Animal getAnimalByName(@PathVariable String animalName);

    public Animal createAnimal(@RequestBody Animal animalDTO);

    public List<Animal> getAnimals();


}
