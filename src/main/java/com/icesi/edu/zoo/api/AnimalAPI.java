package com.icesi.edu.zoo.api;

import com.icesi.edu.zoo.dto.AnimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/animal")
public interface AnimalAPI {

    @GetMapping("/{animalId}")
    List<AnimalDTO> getAnimal(@PathVariable UUID animalId);

    @PostMapping()
    AnimalDTO createAnimal(@RequestBody AnimalDTO animalDTO);

    @GetMapping()
    List<AnimalDTO> getAnimals();

}
