package co.edu.icesi.zoo.controller;

import co.edu.icesi.zoo.api.AnimalAPI;
import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.mapper.AnimalMapper;
import co.edu.icesi.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AnimalController implements AnimalAPI {

    private final AnimalMapper animalMapper;
    private final AnimalService animalService;

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        validateAllFieldsNotNull(animalDTO);
        validateAnimalNameLength(animalDTO.getName());
        validateAnimalNameLength(animalDTO.getName());
        return animalMapper.fromAnimalToDTO(animalService.createAnimal(animalMapper.fromDTOToAnimal(animalDTO)));
    }

    private void validateAllFieldsNotNull(AnimalDTO animalDTO) {
        if (animalDTO.getName() == null || animalDTO.getSex() == null
                || animalDTO.getAge() == 0 || animalDTO.getHeight() == 0.0
                || animalDTO.getWeight() == 0.0 || animalDTO.getArrivalDate() == null)
            throw new RuntimeException();
    }

    @Override
    public AnimalWithParentsDTO getAnimal(String animalName) {
        validateAnimalNameLength(animalName);
        validateAnimalNameCharacters(animalName);
        AnimalWithParentsDTO animalWithParentsDTO = animalMapper.fromAnimalToAnimalWithParentsDTO(animalService.getAnimal(animalName));
        animalWithParentsDTO.setFather(animalMapper.fromAnimalToDTO(animalService.getAnimal(animalWithParentsDTO.getFather().getName())));
        animalWithParentsDTO.setMother(animalMapper.fromAnimalToDTO(animalService.getAnimal(animalWithParentsDTO.getMother().getName())));
        return animalWithParentsDTO;
    }

    private void validateAnimalNameLength(String animalName) {
        if (animalName.length() > 120)
            throw new RuntimeException();
    }

    private void validateAnimalNameCharacters(String animalName) {
        if (!animalName.matches("[a-zA-Z ]+"))
            throw new RuntimeException();
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimalToDTO).collect(Collectors.toList());
    }
}
