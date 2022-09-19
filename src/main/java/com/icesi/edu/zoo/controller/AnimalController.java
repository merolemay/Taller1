package com.icesi.edu.zoo.controller;

import com.icesi.edu.zoo.api.AnimalAPI;
import com.icesi.edu.zoo.dto.AnimalDTO;
import com.icesi.edu.zoo.mapper.AnimalMapper;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalDTO getAnimal(UUID animalId) {
        return null;
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        return null;
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return null;
    }

}
