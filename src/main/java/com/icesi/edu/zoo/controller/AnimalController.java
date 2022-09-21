package com.icesi.edu.zoo.controller;

import com.icesi.edu.zoo.api.AnimalAPI;
import com.icesi.edu.zoo.dto.AnimalDTO;
import com.icesi.edu.zoo.mapper.AnimalMapper;
import com.icesi.edu.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
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
        if(checkNotNull(animalDTO) && nameIsValid(animalDTO.getName())
        && sexIsValid(animalDTO.getSex()) && dateIsValid(animalDTO.getArrivalDate()))
            return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
        throw new RuntimeException();
    }

    private boolean checkNotNull(final AnimalDTO animalDTO) {
        return animalDTO != null;
    }

    private boolean nameIsValid(String name) {
        return name != null && name.length() <= MAX_NAME_LENGTH && name.matches(NAME_REGEX) && !name.isBlank();
    }

    private boolean sexIsValid(char sex) {
        return Character.toString(sex).matches(SEX_REGEX);
    }

    private boolean dateIsValid(Date date) {
        return date != null && date.compareTo(new Date()) <= 0;
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

}
