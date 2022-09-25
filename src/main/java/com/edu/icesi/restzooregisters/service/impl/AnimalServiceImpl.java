package com.edu.icesi.restzooregisters.service.impl;

import com.edu.icesi.restzooregisters.dto.AnimalDTO;
import com.edu.icesi.restzooregisters.error.exception.AnimalError;
import com.edu.icesi.restzooregisters.error.exception.AnimalException;
import com.edu.icesi.restzooregisters.model.Animal;
import com.edu.icesi.restzooregisters.repository.AnimalRepository;
import com.edu.icesi.restzooregisters.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.edu.icesi.restzooregisters.constants.AnimalErrorCode.*;
import static com.edu.icesi.restzooregisters.constants.AnimalErrorCode.CODE_01;
import static com.edu.icesi.restzooregisters.constants.GenericTurtles.*;

@AllArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    public final AnimalRepository animalRepository;

    @Override
    public List<Animal> getAnimal(String animalName) {
        List<Animal> animals = new ArrayList<>();
        Animal animal = getAnimalByName(animalName);
        if(animal == null){
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_01,CODE_01.getMessage()));
        }
        animals.add(animal);
        animals.add(getAnimalById(animal.getFatherID(),false));
        animals.add(getAnimalById(animal.getFatherID(),true));
        return animals;
    }

    private Animal getAnimalById(UUID id,boolean sex){ //False for male. True for female
        if(sex){
            return animalRepository.findById(id).orElse(GENERIC_FEMALE_ANIMAL);
        }
        else{
            return animalRepository.findById(id).orElse(GENERIC_MALE_ANIMAL);
        }
    }

    private Animal getAnimalByName(String animalName) {
        return getAnimals().stream().peek(System.out::println).
                filter(animal -> animal.getName().equalsIgnoreCase(animalName)).findFirst().orElse(null);
    }

    @Override
    public Animal createAnimal(Animal animal) {
        isRepeated(animal.getName());
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }



    private boolean isRepeated(String name){
        List<Animal> animals = getAnimals();
        for (Animal x : animals){
            if (x.getName().equals(name)){
                throw new AnimalException(HttpStatus.CONFLICT, new AnimalError(CODE_07,CODE_07.getMessage()));
            }
        }
        return false;
    }
}
