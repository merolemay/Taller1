package co.edu.icesi.ecozoo.service.impl;

import co.edu.icesi.ecozoo.model.Animal;
import co.edu.icesi.ecozoo.repository.AnimalRepository;
import co.edu.icesi.ecozoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public Animal getAnimal(UUID animalId) {
        Optional<Animal> animal= animalRepository.findById(animalId);
        animal.orElseThrow(() -> new RuntimeException("The animal does not exist"));
        return animal.get();
    }

    @Override
    public Animal getAnimalByName(String name) {
        Optional<Animal> animal= animalRepository.findByName(name);
        animal.orElseThrow(() -> new RuntimeException("The animal does not exist"));
        return animal.get();
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}

