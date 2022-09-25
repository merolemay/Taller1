package co.edu.icesi.apizoo.controller;

import co.edu.icesi.apizoo.api.AnimalAPI;
import co.edu.icesi.apizoo.dto.AnimalDTO;
import co.edu.icesi.apizoo.mapper.AnimalMapper;
import co.edu.icesi.apizoo.model.Animal;
import co.edu.icesi.apizoo.root.exception.ApiZooError;
import co.edu.icesi.apizoo.root.exception.ApiZooException;
import co.edu.icesi.apizoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    private AnimalService animalService;
    private AnimalMapper animalMapper;

    @Override
    public AnimalDTO getAnimal(UUID animalID) {
        return animalMapper.fromAnimal(animalService.getAnimal(animalID));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        if ((validateName(animalDTO.getName()) && !validateUniqueName(animalDTO.getName())) && (validateDate(animalDTO.getArrivalDate()) && validateWeight(animalDTO.getWeight())) && (validateHeight(animalDTO.getHeight()) && validateAge(animalDTO.getAge()))){
            return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
        }else{
            return null;
        }
        //return animalDTO;
    }

    @Override
    public AnimalDTO updateAnimal(AnimalDTO animalDTO) {
        Optional<Animal> parent1 = Optional.of(animalService.getAnimal(animalDTO.getFatherID()));
        Optional<Animal> parent2 = Optional.of(animalService.getAnimal(animalDTO.getMotherID()));

        if(parent1.isPresent() && parent2.isPresent()){
            if(parent1.get().getSex().equalsIgnoreCase("Male") && parent1.get().getSex().equalsIgnoreCase("Female")){
               animalService.updateAnimal(animalMapper.fromDTO(animalDTO));
            }
        }else{
            throw new ApiZooException(HttpStatus.BAD_REQUEST, new ApiZooError("",""));
        }
        return animalDTO;
    }

    private boolean validateWeight(Double weight) {
        if(weight >= 60 && weight <= 140){
            return true;
        }else{
            throw new ApiZooException(HttpStatus.PRECONDITION_FAILED, new ApiZooError("412", "The expected weight is between 60 and 140 kg."));
        }
    }

    private boolean validateHeight(Double height) {
        if(height >= 0.80 && height <= 1.0){
            return true;
        }else{
            throw new ApiZooException(HttpStatus.PRECONDITION_FAILED, new ApiZooError("412", "The expected height is between 0.80 and 1.0 kg."));
        }
    }

    private boolean validateAge(Integer age){
        if(age <= 20){
            return true;
        }else{
            throw new ApiZooException(HttpStatus.PRECONDITION_FAILED, new ApiZooError("412", "Age is expected to be less than 20 years old."));
        }
    }

    private boolean validateDate(LocalDateTime arrivalDate) {
        if(arrivalDate.isAfter(LocalDateTime.now())){
            return true;
        }else{
            throw new ApiZooException(HttpStatus.NOT_ACCEPTABLE, new ApiZooError("406","Invalid Date: The date must be before the current date."));
        }
    }

    private boolean validateUniqueName(String name) {
        if(!animalService.getAnimals().contains(name)){
            return true;
        }else{
            throw new ApiZooException(HttpStatus.CONFLICT, new ApiZooError("409", "Invalid name: Already registered in the system, the name must be unique."));
        }
    }

    private boolean validateName(String name) {
        if(name.length() <= 120 & name.matches("^[a-zA-Z\\s]*$")){
            return true;
        }else{
            throw new ApiZooException(HttpStatus.NOT_ACCEPTABLE, new ApiZooError("406", "Invalid name: Can only have letters and spaces, up to 120 digits."));
        }
    }
}
