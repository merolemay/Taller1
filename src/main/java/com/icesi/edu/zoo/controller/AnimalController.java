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

    private final String NAME_REGEX = "[a-zA-Z\\s]*[\\S?]";
    //ADULT
    private final int ADULT_AGE = 6;
    //KG
    private final double MIN_ADULT_WEIGHT = 9;
    private final double MAX_ADULT_WEIGHT = 15;
    //CM
    private final double MIN_ADULT_HEIGHT = 100;
    private final double MAX_ADULT_HEIGHT = 130;
    //YOUNG
    //KG
    private final double MIN_YOUNG_WEIGHT = 9;
    private final double MAX_YOUNG_WEIGHT = 15;
    //CM
    private final double MIN_YOUNG_HEIGHT = 100;
    private final double MAX_YOUNG_HEIGHT = 130;

    @Override
    public AnimalDTO getAnimal(UUID animalId) {
        return animalMapper.fromAnimal(animalService.getAnimal(animalId));
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        if(checkNotNull(animalDTO) && nameIsValid(animalDTO.getName()) && checkCharacteristics(animalDTO)
        && sexIsValid(animalDTO.getSex()) && dateIsValid(animalDTO.getArrivalDate()))
            return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
        throw new RuntimeException();
    }

    private boolean checkNotNull(AnimalDTO animalDTO) {
        return animalDTO != null;
    }

    private boolean nameIsValid(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    private boolean sexIsValid(char sex) {
        return (sex == 'h' || sex == 'H') || (sex == 'm' || sex == 'F');
    }

    private boolean dateIsValid(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date current = new Date();
        return date != null && LocalDate.parse(date.toString()).compareTo(OffsetDateTime.parse(current.toString()).toLocalDate()) <= 0;
    }

    private boolean checkCharacteristics(AnimalDTO animalDTO) {
        boolean adult = animalDTO.getAge() >= ADULT_AGE;
        double height = animalDTO.getHeight();
        double weight = animalDTO.getWeight();
        if(adult)
            return inClosedRange(height, MIN_ADULT_HEIGHT, MAX_ADULT_HEIGHT) && inClosedRange(weight, MIN_ADULT_WEIGHT, MAX_ADULT_WEIGHT);
        else
            return inClosedRange(height, MIN_YOUNG_HEIGHT, MAX_YOUNG_HEIGHT) && inClosedRange(weight, MIN_YOUNG_WEIGHT, MAX_YOUNG_WEIGHT);
    }

    private boolean inClosedRange(double num, double min, double max) {
        return (num >= min) && (num <= max);
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

}
