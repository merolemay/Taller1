package com.edu.icesi.conceptsreview.service.impl;

import com.edu.icesi.conceptsreview.dto.AnimalParentsDTO;
import com.edu.icesi.conceptsreview.dto.AnimalParentsObjectDTO;
import com.edu.icesi.conceptsreview.error.exception.AnimalError;
import com.edu.icesi.conceptsreview.error.exception.AnimalException;
import com.edu.icesi.conceptsreview.mapper.AnimalMapper;
import com.edu.icesi.conceptsreview.model.Animal;
import com.edu.icesi.conceptsreview.repository.AnimalRepository;
import com.edu.icesi.conceptsreview.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.edu.icesi.conceptsreview.constant.AnimalsErrorCodes.*;
import static com.edu.icesi.conceptsreview.constant.Errors.*;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Animal createAnimal(Animal animalDTO) {

        verifyAnimalNameAlreadyExists(animalDTO);

        verifyAnimalAlreadyExistsByID(animalDTO.getFatherId(), " father id");
        verifyAnimalGenre(animalDTO.getFatherId(), "M", ": father");

        verifyAnimalAlreadyExistsByID(animalDTO.getMotherId(), " mother id");
        verifyAnimalGenre(animalDTO.getMotherId(), "W", ": mother");

        return animalRepository.save(animalDTO);
    }

    @Override
    public Animal getAnimal(UUID animalId) {
        return animalRepository.findById(animalId).orElseThrow(
                () -> new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_02, MSG_CODE_02)));
    }

    @Override
    public AnimalParentsObjectDTO getAnimalWithParents(UUID animalId) {
        Animal animalForFill = getAnimal(animalId);
        AnimalParentsObjectDTO animalForReturn = animalMapper.fromAnimalToAnimalParentsObjectDTO(animalForFill);
        animalForReturn.setFather(animalMapper.fromAnimalToAnimalDTO(Optional.ofNullable(animalForFill.getFatherId()).map(this::getAnimal).orElse(null)));
        animalForReturn.setMother(animalMapper.fromAnimalToAnimalDTO(Optional.ofNullable(animalForFill.getMotherId()).map(this::getAnimal).orElse(null)));
        return animalForReturn;
    }

    private void verifyAnimalNameAlreadyExists(Animal animalDTO) {
        List<Animal> animalsCreated = getAnimals();
        for (Animal animal : animalsCreated) {
            if(animal.getName().equalsIgnoreCase(animalDTO.getName())) {
                throw new AnimalException(HttpStatus.BAD_REQUEST, new AnimalError(CODE_03, MSG_CODE_03));
            }
        }
    }

    private int verifyAnimalAlreadyExistsByID(UUID animalId, String optionalMsg) {
        if(animalId == null || animalId.equals("")) {
            return 0;
        }
        if(getAnimal(animalId) == null) {
            throw new AnimalException(HttpStatus.BAD_REQUEST,
                    new AnimalError(CODE_02, MSG_CODE_02 + optionalMsg));
        }
        return 0;
    }

    private int verifyAnimalGenre(UUID animalId, String genre, String optionalMessage) {
        if(animalId == null || animalId.equals("")) {
            return 0;
        }
        Animal animal = getAnimal(animalId);
        if(!animal.getGender().equalsIgnoreCase(genre)) {
            throw new AnimalException(HttpStatus.BAD_REQUEST,
                    new AnimalError(CODE_04, MSG_CODE_04 + optionalMessage));
        }
        return 0;
    }
}
