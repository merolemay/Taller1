package co.edu.icesi.zoo.controller;

import co.edu.icesi.zoo.api.AnimalAPI;
import co.edu.icesi.zoo.model.Animal;
import co.edu.icesi.zoo.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    private final AnimalRepository animalRepository;

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
}
