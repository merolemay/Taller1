package co.edu.icesi.zoo.service.impl;

import co.edu.icesi.zoo.model.Animal;
import co.edu.icesi.zoo.repository.AnimalRepository;
import co.edu.icesi.zoo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Animal> animal = animalRepository.findByName(animalName);
        if (animal.isEmpty())
            throw new RuntimeException();
        return animal.get();
    }

    @Override
    public Optional<Animal> getNullableAnimal(String animalName) {
        return animalRepository.findByName(animalName);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
