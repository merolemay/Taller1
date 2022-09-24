package co.edu.icesi.zoo.controller;

import co.edu.icesi.zoo.api.AnimalAPI;
import co.edu.icesi.zoo.constant.AnimalErrorCode;
import co.edu.icesi.zoo.constant.AnimalGender;
import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoo.error.exception.AnimalError;
import co.edu.icesi.zoo.error.exception.AnimalException;
import co.edu.icesi.zoo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AnimalController implements AnimalAPI {

    private final AnimalService animalService;

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        validateAllFieldsNotNull(animalDTO);
        validateAnimalNameLength(animalDTO);
        validateAnimalNameCharacters(animalDTO);
        validateSexOfFather(animalDTO);
        validateSexOfMother(animalDTO);
        validateAnimalWeight(animalDTO);
        validateAnimalHeight(animalDTO);
        return animalService.getDTOFromAnimal(animalService.createAnimal(animalService.getAnimalFromDTO(animalDTO)));
    }

    private void validateAllFieldsNotNull(AnimalDTO animalDTO) {
        if (animalDTO.getName() == null || animalDTO.getSex() == null
                || animalDTO.getAge() == 0 || animalDTO.getHeight() == 0.0
                || animalDTO.getWeight() == 0.0 || animalDTO.getArrivalDate() == null)
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_01, AnimalErrorCode.CODE_01.getMessage()));
    }

    private void validateSexOfFather(AnimalDTO animalDTO) {
        if (animalDTO.getFather() != null && validateAnimalExists(animalDTO.getFather()))
            if (animalService.getAnimal(animalDTO.getFather()).getSex() != AnimalGender.M)
                throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_02, AnimalErrorCode.CODE_02.getMessage()));
    }

    private void validateSexOfMother(AnimalDTO animalDTO) {
        if (animalDTO.getMother() != null && validateAnimalExists(animalDTO.getMother()))
            if (animalService.getAnimal(animalDTO.getMother()).getSex() != AnimalGender.F)
                throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_03, AnimalErrorCode.CODE_03.getMessage()));
    }

    private boolean validateAnimalExists(String animalName) {
        if (animalName != null && animalService.getAnimal(animalName) == null)
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_05, AnimalErrorCode.CODE_05.getMessage()));
        return true;
    }

    private void validateAnimalNameLength(AnimalDTO animalDTO) {
        if (animalDTO.getName().length() > 120)
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_04, AnimalErrorCode.CODE_04.getMessage()));
    }

    private void validateAnimalNameCharacters(AnimalDTO animalDTO) {
        if (!animalDTO.getName().matches("[a-zA-Z ]+"))
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_06, AnimalErrorCode.CODE_06.getMessage()));
    }

    private void validateAnimalWeight(AnimalDTO animalDTO) {
        if (animalDTO.getWeight() < 0.3 || animalDTO.getWeight() > 200)
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_07, AnimalErrorCode.CODE_07.getMessage()));
    }

    private void validateAnimalHeight(AnimalDTO animalDTO) {
        if (animalDTO.getHeight() < 0.1 || animalDTO.getWeight() > 2)
            throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(AnimalErrorCode.CODE_08, AnimalErrorCode.CODE_08.getMessage()));
    }

    @Override
    public AnimalWithParentsDTO getAnimal(String animalName) {
        return animalService.getAnimalWithParentsFromAnimal(animalService.getAnimal(animalName));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalService::getDTOFromAnimal).collect(Collectors.toList());
    }
}
