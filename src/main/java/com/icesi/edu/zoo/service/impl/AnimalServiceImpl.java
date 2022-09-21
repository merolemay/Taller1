package com.icesi.edu.zoo.service.impl;

import com.icesi.edu.zoo.constant.CondorCharacteristics;
import com.icesi.edu.zoo.model.Animal;
import com.icesi.edu.zoo.repository.AnimalRepository;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<Animal> getAnimal(UUID animalId) {
        return createFamilyList(animalId);
    }

    private List<Animal> createFamilyList(UUID animalId) {
        List<Animal> family = new ArrayList<>();
        Animal child = animalRepository.findById(animalId).orElse(null);
        if(child != null) {
            family.add(child);
            family.add(animalRepository.findById(child.getMaleParentId()).orElse(null));
            family.add(animalRepository.findById(child.getFemaleParentId()).orElse(null));
            family.removeAll(Collections.singleton(null));
        }
        return family;
    }

    @Override
    public Animal createAnimal(Animal animalDTO) {
        if(!animalExists(animalDTO.getId())
                && animalExists(animalDTO.getMaleParentId())
                && animalExists(animalDTO.getFemaleParentId())
                && parentsAreDifferent(animalDTO.getMaleParentId(), animalDTO.getFemaleParentId())
                && checkParentSex(animalDTO.getMaleParentId(), "m")
                && checkParentSex(animalDTO.getFemaleParentId(), "h")
                && nameIsValid(animalDTO.getName()))
            return animalRepository.save(animalDTO);
        throw new RuntimeException();
    }

    private boolean animalExists(UUID animalId) {
        return animalId == null || animalRepository.findById(animalId).isPresent();
    }

    private boolean checkParentSex(UUID animalId, String sex) {
        if(animalId == null)
            return true;
        Animal parent = animalRepository.findById(animalId).orElse(null);
        return Character.toString(parent.getSex()).equalsIgnoreCase(sex);
    }

    private boolean parentsAreDifferent(UUID maleId, UUID femaleId) {
        return maleId == null || femaleId == null || maleId.compareTo(femaleId) != 0;
    }

    private boolean nameIsValid(String animalName) {
        return true;
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
