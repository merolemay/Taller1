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

    @Override
    public AnimalDTO getAnimal(UUID animalId) {
        return animalMapper.fromAnimal(animalService.getAnimal(animalId));
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

}
