package icesi.edu.co.Lavoro.controller;

import icesi.edu.co.Lavoro.api.AnimalAPI;
import icesi.edu.co.Lavoro.constant.AnimalErrorCode;
import icesi.edu.co.Lavoro.dto.AnimalDTO;
import icesi.edu.co.Lavoro.error.exception.AnimalDemoError;
import icesi.edu.co.Lavoro.error.exception.AnimalDemoException;
import icesi.edu.co.Lavoro.mapper.AnimalMapper;
import icesi.edu.co.Lavoro.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        if(animalID!=null){
        return animalMapper.fromAnimal(animalService.getAnimal(animalID)); }
        else {
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST,
                    new AnimalDemoError(""+AnimalErrorCode.CODE_UD_01,"The name shouldn't be null"));
        }
    }

    @Override
    public AnimalDTO getAnimalbyName(String animalID) {
        if(animalID!=null){
            return animalMapper.fromAnimal(animalService.getAnimalByName(animalID)); }
        else {
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST,
                    new AnimalDemoError(""+AnimalErrorCode.CODE_UD_01,"The name shouldn't be null"));
        }
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        verifyWord(animalDTO.getName());
        return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

    private void verifyWord(String s){
        verifyWordFormat(s);
        wordLengthFormatChecker(s);
    }
    private void wordLengthFormatChecker(String word) {
        if(word==null || word.length()>120) {
            throw new AnimalDemoException(HttpStatus.LENGTH_REQUIRED,
                    new AnimalDemoError(""+ AnimalErrorCode.CODE_UD_01,"Thw word length should not be longer than 120 chars"));
        }
    }

    private void verifyWordFormat(String s) {
        if(s==null || !s.matches("[a-zA-Z]+\\w*[a-zA-Z]+"))
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST,
                    new AnimalDemoError(""+AnimalErrorCode.CODE_UD_01,"The name shouldn't contain spaces"));
    }
}
