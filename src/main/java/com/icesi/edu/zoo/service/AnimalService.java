package com.icesi.edu.zoo.service;

import com.icesi.edu.zoo.model.Animal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    Animal getAnimal(@PathVariable UUID animalId);

    Animal createAnimal(@RequestBody Animal animalDTO);

    List<Animal> getAnimals();

}
