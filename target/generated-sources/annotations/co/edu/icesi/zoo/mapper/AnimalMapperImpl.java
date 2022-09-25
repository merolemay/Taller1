package co.edu.icesi.zoo.mapper;

import co.edu.icesi.zoo.dto.AnimalDTO;
import co.edu.icesi.zoo.model.Animal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-24T22:57:41-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
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
        animal.gender( animalDTO.getGender() );
        animal.weight( animalDTO.getWeight() );
        animal.age( animalDTO.getAge() );
        animal.height( animalDTO.getHeight() );
        animal.arrivalDate( animalDTO.getArrivalDate() );
        animal.fatherId( animalDTO.getFatherId() );
        animal.motherId( animalDTO.getMotherId() );

        return animal.build();
    }

    @Override
    public AnimalDTO fromAnimal(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        AnimalDTO animalDTO = new AnimalDTO();

        animalDTO.setId( animal.getId() );
        animalDTO.setName( animal.getName() );
        animalDTO.setGender( animal.getGender() );
        animalDTO.setWeight( animal.getWeight() );
        animalDTO.setAge( animal.getAge() );
        animalDTO.setHeight( animal.getHeight() );
        animalDTO.setArrivalDate( animal.getArrivalDate() );
        animalDTO.setFatherId( animal.getFatherId() );
        animalDTO.setMotherId( animal.getMotherId() );

        return animalDTO;
    }
}
