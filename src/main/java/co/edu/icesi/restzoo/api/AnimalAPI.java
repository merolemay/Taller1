package co.edu.icesi.restzoo.api;

import co.edu.icesi.restzoo.dto.AnimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/animals")
public interface AnimalAPI {

    @GetMapping("/id={animalId}")
    AnimalDTO getAnimalById(@PathVariable UUID animalId);

    @GetMapping("/name={animalName}")
    AnimalDTO getAnimalByName(@PathVariable String animalName);

    @PostMapping()
    AnimalDTO createAnimal(@RequestBody AnimalDTO animalDTO);

    @GetMapping()
    List<AnimalDTO> getAnimals();
}
