package com.icesi.edu.zoo.api;

import com.icesi.edu.zoo.dto.AnimalDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/animal")
public interface AnimalAPI {

    @GetMapping("/{animalName}")
    List<AnimalDTO> getAnimal(@PathVariable String animalId);

    @PostMapping()
    AnimalDTO createAnimal(@RequestBody AnimalDTO animalDTO);

    @GetMapping()
    List<AnimalDTO> getAnimals();

}
