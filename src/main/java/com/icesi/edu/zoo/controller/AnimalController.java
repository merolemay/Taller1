package com.icesi.edu.zoo.controller;

import com.icesi.edu.zoo.api.AnimalAPI;
import com.icesi.edu.zoo.dto.AnimalDTO;
import com.icesi.edu.zoo.error.exception.AnimalError;
import com.icesi.edu.zoo.error.exception.AnimalException;
import com.icesi.edu.zoo.mapper.AnimalMapper;
import com.icesi.edu.zoo.service.AnimalService;
import static com.icesi.edu.zoo.constant.AnimalErrorCode.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    private final String NAME_REGEX = "^[a-zA-Z\\s]*$";
    private final String SEX_REGEX = "^[m|M|h|H]$";
    private final int MAX_NAME_LENGTH = 120;

    @Override
    public List<AnimalDTO> getAnimal(UUID animalId) {
        return animalService.getAnimal(animalId).stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        checkNotNull(animalDTO);
        nameIsValid(animalDTO.getName());
        sexIsValid(animalDTO.getSex());
        dateIsValid(animalDTO.getArrivalDate());
        return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
    }

    private boolean checkNotNull(final AnimalDTO animalDTO) {
        if(animalDTO != null)
            return true;
        throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_01, CODE_01.getMessage()));
    }

    private boolean nameIsValid(String name) {
        if(name != null && !name.isBlank() && name.length() <= MAX_NAME_LENGTH && name.matches(NAME_REGEX))
            return true;
        throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_02, CODE_02.getMessage()));
    }

    private boolean sexIsValid(char sex) {
        if(Character.toString(sex).matches(SEX_REGEX))
            return true;
        throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_03, CODE_03.getMessage()));
    }

    private boolean dateIsValid(Date date) {
        if(date != null && date.compareTo(new Date()) <= 0)
            return true;
        throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_04, CODE_04.getMessage()));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

}
