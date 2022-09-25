package co.edu.icesi.Zootopia.controller;

import co.edu.icesi.Zootopia.DTO.AnimalDTO;
import co.edu.icesi.Zootopia.api.AnimalAPI;
import co.edu.icesi.Zootopia.mapper.AnimalMapper;
import co.edu.icesi.Zootopia.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    public final AnimalMapper animalMapper;
    public final AnimalService animalService;

    @Override
    public AnimalDTO getAnimalUsingName(String name) {
        return animalMapper.fromAnimal(animalService.getAnimalUsingName(name));
    }

    @Override
    public AnimalDTO getAnimalUsingId(UUID id) {
        return animalMapper.fromAnimal(animalService.getAnimalUsingId(id));
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }
}
