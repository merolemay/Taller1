package com.edu.icesi.restzooregisters.api;

import com.edu.icesi.restzooregisters.dto.AnimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/zooregisters")
public interface RestZooRegistersAPI {
    @GetMapping("/{animalName}")
    public List<AnimalDTO> getAnimal(@PathVariable String animalName );

    @PostMapping()
    public AnimalDTO createAnimal(@RequestBody AnimalDTO animalDTO);

    @GetMapping
    public List<AnimalDTO> getAnimals();

    @PostMapping("/{animalName}") //Created for parents update
    AnimalDTO updateAnimal(@PathVariable String animalName, @RequestBody AnimalDTO animalDTO);
}
