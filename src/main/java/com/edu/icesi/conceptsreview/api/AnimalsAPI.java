package com.edu.icesi.conceptsreview.api;


import com.edu.icesi.conceptsreview.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/animals")
public interface AnimalsAPI {

    @PostMapping()
    public AnimalDTO createAnimal(@RequestBody AnimalParentsDTO animalParentsDTO);

    @GetMapping()
    public List<AnimalDTO> getAnimals();

    @GetMapping("/{animalId}")
    public AnimalParentsObjectDTO getAnimal(@PathVariable UUID animalId);

}
