package icesi.edu.co.Lavoro.controller;

import icesi.edu.co.Lavoro.api.AnimalAPI;
import icesi.edu.co.Lavoro.dto.AnimalDTO;
import icesi.edu.co.Lavoro.mapper.AnimalMapper;
import icesi.edu.co.Lavoro.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@RestController
public class AnimalController implements AnimalAPI {


    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalDTO getAnimal(UUID animalID) {
        return animalMapper.fromAnimal(animalService.getAnimal(animalID)); }

    @Override
    public AnimalDTO getAnimalbyName(String animalID) { return animalMapper.fromAnimal(animalService.getAnimalByName(animalID)); }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

}
