package com.icesi.edu.zoo.controller;

import com.icesi.edu.zoo.api.AnimalAPI;
import com.icesi.edu.zoo.dto.AnimalDTO;
import com.icesi.edu.zoo.mapper.AnimalMapper;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    private final String NAME_REGEX = "";
    private final double MIN_MALE_WEIGHT = 11;
    private final double MAX_MALE_WEIGHT = 15;
    private final double MIN_FEMALE_WEIGHT = 8;
    private final double MAX_FEMALE_WEIGHT = 11;
    private final double MIN_ADULT_HEIGHT = 100;
    private final double MAX_ADULT_HEIGHT = 130;

    @Override
    public AnimalDTO getAnimal(UUID animalId) {
        return animalMapper.fromAnimal(animalService.getAnimal(animalId));
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        if(checkNotNull(animalDTO) && nameIsValid(animalDTO.getName()) && checkCharacteristics(animalDTO))
            return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
        throw new RuntimeException();
    }

    private boolean checkNotNull(AnimalDTO animalDTO) {
        return animalDTO != null;
    }

    private boolean nameIsValid(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    private boolean checkCharacteristics(AnimalDTO animalDTO) {
        return false;
    }


    private boolean inClosedRange(double num, double min, double max) {
        return (num >= min) && (num <= max);
    }





    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

}
