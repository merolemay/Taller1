package co.edu.icesi.zoologico.controller;

import co.edu.icesi.zoologico.api.ZooAPI;
import co.edu.icesi.zoologico.dto.AnimalDTO;
import co.edu.icesi.zoologico.dto.AnimalWithParentsDTO;
import co.edu.icesi.zoologico.error.exception.AnimalDemoError;
import co.edu.icesi.zoologico.error.exception.AnimalDemoException;
import co.edu.icesi.zoologico.mapper.AnimalMapper;
import co.edu.icesi.zoologico.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ZooController implements ZooAPI {

    private final AnimalMapper animalMapper;

    private final ZooService zooService;


    @Override
    public AnimalWithParentsDTO getAnimalByName(String animalName) {
        return zooService.getAnimalByName(animalName);
    }



    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {

        verifyAnimalNameEmpty(animalDTO.getName());
        verifyAnimalNameLength(animalDTO.getName());
        verifyAnimalArrivalDate(animalDTO.getArrivalDate());
        verifyAnimalAge(animalDTO.getAge());
        verifyAnimalHeight(animalDTO.getHeight());
        verifyAnimalWeight(animalDTO.getWeight());
        return animalMapper.fromAnimal(zooService.createAnimal(animalMapper.fromDTO(animalDTO)));

    }


    @Override
    public List<AnimalDTO> getAnimals() {
        return zooService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }


    private boolean verifyAnimalNameEmpty(String animalName){
        if(animalName==null||animalName.isEmpty()) {
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST, new AnimalDemoError("1234","Throw AnimalDemoException - Name is empty"));
        }else{
            return true;
        }
    }

    private boolean verifyAnimalNameLength(String animalName){

        if(animalName.length() <= 120  && animalName.matches("^[a-z A-Z]*$")){
            return true;
        }else{
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST, new AnimalDemoError("1234","Throw AnimalDemoException - Name Invalid Format"));
        }
    }

    private boolean verifyAnimalArrivalDate(LocalDateTime arrivalDate){
        LocalDateTime now=LocalDateTime.now();

        if (!now.isAfter(arrivalDate)){
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST, new AnimalDemoError("1234","Throw AnimalDemoException -  Invalid Arrival Date"));
        }
            return true;
    }

    private boolean verifyAnimalHeight(Integer animalHeight){
        int minHeightZorroCañeroInCm=10;
        int maxHeightZorroCañeroInCm=90;

        if (animalHeight<maxHeightZorroCañeroInCm&&animalHeight>minHeightZorroCañeroInCm){
            return true;
        }else{
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST, new AnimalDemoError("1234","Throw AnimalDemoException -  Height is anormal for Zorro Cañero, the max value is: "+maxHeightZorroCañeroInCm));
        }
    }

    private boolean verifyAnimalWeight(Integer animalWeight){
        int minHeightZorroCañeroInKg=10;
        int maxHeightZorroCañeroInKg=50;

        if (animalWeight<maxHeightZorroCañeroInKg&&animalWeight>minHeightZorroCañeroInKg){
            return true;
        }else{
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST, new AnimalDemoError("1234","Throw AnimalDemoException -  Weight is anormal for Zorro Cañero, the max value is "+maxHeightZorroCañeroInKg));
        }
    }

    private boolean verifyAnimalAge(Integer animalAge){
        int maxAgeZorroCañeroInYears=90;

        if (animalAge<maxAgeZorroCañeroInYears){
            return true;
        }else{
            throw new AnimalDemoException(HttpStatus.BAD_REQUEST, new AnimalDemoError("1234","Throw AnimalDemoException -  Age is anormal for Zorro Cañero , the max value is "+maxAgeZorroCañeroInYears));
        }
    }

}


