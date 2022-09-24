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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.edu.icesi.restzooregisters.constants.AnimalErrorCode.CODE_02;
import static com.edu.icesi.restzooregisters.constants.AnimalErrorCode.CODE_07;

@AllArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    public final AnimalRepository animalRepository;

    @Override
    public Animal getAnimal(String animalName) {
        return new Animal(); //WIP
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
                throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_07,CODE_07.getMessage()));
            }
        }
        return false;
    }
}
