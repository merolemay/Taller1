package icesi.edu.co.Lavoro.service.impl;

import icesi.edu.co.Lavoro.constant.AnimalErrorCode;
import icesi.edu.co.Lavoro.constant.AnimalSexCode;
import icesi.edu.co.Lavoro.error.exception.AnimalDemoError;
import icesi.edu.co.Lavoro.error.exception.AnimalDemoException;
import icesi.edu.co.Lavoro.model.Animal;
import icesi.edu.co.Lavoro.repository.AnimalRepository;
import icesi.edu.co.Lavoro.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Primary
public class  AnimalServiceImpl implements AnimalService {

    public final AnimalRepository animalRepository;

    @Override
    public Animal getAnimal(UUID animalID) {
        return animalRepository.findById(animalID).orElseThrow(() -> new AnimalDemoException(HttpStatus.NOT_FOUND,
                new AnimalDemoError(AnimalErrorCode.CODE_UD_05,AnimalErrorCode.CODE_UD_05.getMessage())));
    }

    @Override
    public Animal getAnimalByName(String animalName) {
        return animalRepository.findByName(animalName).orElseThrow(() -> new AnimalDemoException(HttpStatus.NOT_FOUND,
                new AnimalDemoError(AnimalErrorCode.CODE_UD_05,AnimalErrorCode.CODE_UD_05.getMessage())));
    }

    @Override
    public Animal createAnimal(@Valid Animal animalDTO) {
        verifyAll(animalDTO);
        return animalRepository.save(animalDTO);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    private void nameIsUnique(String name) {
            animalRepository.findByName(name).ifPresent(animal -> {
                new AnimalDemoException(HttpStatus.FOUND,
                        new AnimalDemoError(AnimalErrorCode.CODE_UD_06,AnimalErrorCode.CODE_UD_06.getMessage()));
            });
    }

    private void verifyMotherSex(UUID mID) {
        if(mID!=null) {
            Animal mother = getAnimal(mID);
            if(mother.isSex() != AnimalSexCode.FEMALE.isValue())
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST,
                    new AnimalDemoError(AnimalErrorCode.CODE_UD_03, AnimalErrorCode.CODE_UD_03.getMessage()));
        }
    }

    private void verifyFatherSex(UUID fID) {
        if(fID!=null) {
            Animal father = getAnimal(fID);
            if(father.isSex() != AnimalSexCode.MALE.isValue())
                throw new AnimalDemoException(HttpStatus.BAD_REQUEST,
                        new AnimalDemoError(AnimalErrorCode.CODE_UD_04, AnimalErrorCode.CODE_UD_04.getMessage()));
        }
    }

    private void verifyAll(Animal animalDTO) {
        nameIsUnique(animalDTO.getName());
        verifyFatherSex(animalDTO.getFatherID());
        verifyMotherSex(animalDTO.getMotherID());

    }

}
