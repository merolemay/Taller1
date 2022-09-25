package co.edu.icesi.apizoo.api;

import co.edu.icesi.apizoo.dto.AnimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/animals")
public interface AnimalAPI{

    @GetMapping("/{animalID}")
    AnimalDTO getAnimal(@PathVariable UUID animalID);

    @GetMapping
    List<AnimalDTO> getAnimals();

    @PostMapping()
    AnimalDTO createAnimal(@RequestBody AnimalDTO animalDTO);

    @PutMapping()
    AnimalDTO updateAnimal(AnimalDTO animalDTO);
}

