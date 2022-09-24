package com.edu.icesi.conceptsreview.service;

import com.edu.icesi.conceptsreview.dto.AnimalParentsObjectDTO;
import com.edu.icesi.conceptsreview.model.Animal;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    public List<Animal> getAnimals();

    public Animal createAnimal(@RequestBody Animal animalDTO);

    public Animal getAnimal(UUID animalId);

    public AnimalParentsObjectDTO getAnimalWithParents(UUID animalId);

}
