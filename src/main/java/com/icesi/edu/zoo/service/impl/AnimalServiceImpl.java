package com.icesi.edu.zoo.service.impl;

import com.icesi.edu.zoo.constant.CondorCharacteristics;
import com.icesi.edu.zoo.model.Animal;
import com.icesi.edu.zoo.repository.AnimalRepository;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        if(!animalExists(animalDTO.getId()) && animalExists(animalDTO.getMaleParentId()) && animalExists(animalDTO.getFemaleParentId()))
            return animalRepository.save(animalDTO);
        throw new RuntimeException();
    }

    private boolean animalExists(UUID animalId) {
        return animalId == null || animalRepository.findById(animalId).isPresent();
    }

    private boolean checkCharacteristics(Animal animalDTO) {
        double height = animalDTO.getHeight();
        double weight = animalDTO.getWeight();
        return hasValidCharacteristic(height, CondorCharacteristics.HEIGHT) && hasValidCharacteristic(weight, CondorCharacteristics.WEIGHT);
    }

    private <T extends CondorCharacteristics> boolean hasValidCharacteristic(double height, T attr) {
        return inClosedRange(height, attr.getMin(), attr.getMax());
    }

    private boolean inClosedRange(double num, double min, double max) {
        return (num >= min) && (num <= max);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
