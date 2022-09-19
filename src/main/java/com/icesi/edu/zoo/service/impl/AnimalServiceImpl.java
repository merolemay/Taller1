package com.icesi.edu.zoo.service.impl;

import com.icesi.edu.zoo.model.Animal;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Primary
public class AnimalServiceImpl implements AnimalService {

    @Override
    public Animal getAnimal(UUID animalId) {
        return null;
    }

    @Override
    public Animal createAnimal(Animal animalDTO) {
        return null;
    }

    @Override
    public List<Animal> getAnimals() {
        return null;
    }

}
