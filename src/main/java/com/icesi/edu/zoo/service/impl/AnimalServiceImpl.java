package com.icesi.edu.zoo.service.impl;

import com.icesi.edu.zoo.model.Animal;
import com.icesi.edu.zoo.repository.AnimalRepository;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
@Primary
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public Animal getAnimal(UUID animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    @Override
    public Animal createAnimal(Animal animalDTO) {
        return animalRepository.save(animalDTO);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
