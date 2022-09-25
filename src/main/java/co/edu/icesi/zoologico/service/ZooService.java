package co.edu.icesi.zoologico.service;

import co.edu.icesi.zoologico.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoologico.model.Animal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


public interface ZooService {


    //public Animal getAnimal(@PathVariable UUID animalId);

    public AnimalWithParentsDTO getAnimalByName(@PathVariable String animalName);

    public Animal createAnimal(@RequestBody Animal animalDTO);


    public List<Animal> getAnimals();

}
