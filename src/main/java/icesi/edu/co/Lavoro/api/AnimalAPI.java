package icesi.edu.co.Lavoro.api;

import icesi.edu.co.Lavoro.dto.AnimalDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/animals")
public interface AnimalAPI {

    @GetMapping("/{animalID}")
    public AnimalDTO getAnimal(@PathVariable UUID animalID);

    @GetMapping("/{animalName}")
    public AnimalDTO getAnimalbyName(@PathVariable String animalID);

    @PostMapping
    public AnimalDTO createAnimal(@RequestBody AnimalDTO animalDTO);

    @GetMapping
    public List<AnimalDTO> getAnimals();
}
