package com.icesi.edu.zoo.mapper;

import com.icesi.edu.zoo.dto.AnimalDTO;
import com.icesi.edu.zoo.model.Animal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-19T14:57:19-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public Animal fromDTO(AnimalDTO animalDTO) {
        if ( animalDTO == null ) {
            return null;
        }

        Animal.AnimalBuilder animal = Animal.builder();

        animal.id( animalDTO.getId() );
        animal.name( animalDTO.getName() );
        animal.maleParentId( animalDTO.getMaleParentId() );
        animal.femaleParentId( animalDTO.getFemaleParentId() );
        animal.sex( animalDTO.isSex() );
        animal.weight( animalDTO.getWeight() );
        animal.age( animalDTO.getAge() );
        animal.height( animalDTO.getHeight() );
        animal.arrivalDate( animalDTO.getArrivalDate() );

        return animal.build();
    }

    @Override
    public AnimalDTO fromAnimal(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        AnimalDTO.AnimalDTOBuilder animalDTO = AnimalDTO.builder();

        animalDTO.id( animal.getId() );
        animalDTO.name( animal.getName() );
        animalDTO.maleParentId( animal.getMaleParentId() );
        animalDTO.femaleParentId( animal.getFemaleParentId() );
        animalDTO.sex( animal.isSex() );
        animalDTO.weight( animal.getWeight() );
        animalDTO.age( animal.getAge() );
        animalDTO.height( animal.getHeight() );
        animalDTO.arrivalDate( animal.getArrivalDate() );

        return animalDTO.build();
    }
}
