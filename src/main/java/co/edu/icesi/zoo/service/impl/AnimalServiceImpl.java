package co.edu.icesi.zoo.service.impl;

import co.edu.icesi.zoo.model.Animal;
import co.edu.icesi.zoo.repository.AnimalRepository;
import co.edu.icesi.zoo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal getAnimal(String animalName) {
        return animalRepository.findByName(animalName).orElse(null);
    }

    @Override
    public Animal getAnimal(UUID id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
