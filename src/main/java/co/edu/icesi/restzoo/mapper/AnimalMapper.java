package co.edu.icesi.restzoo.mapper;

import co.edu.icesi.restzoo.dto.AnimalDTO;
import co.edu.icesi.restzoo.model.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal fromDTO(AnimalDTO animalDTO);

    AnimalDTO fromAnimal(Animal animal);

    @Mapping(source = "child.id", target = "id")
    @Mapping(source = "child.name", target = "name")
    @Mapping(source = "child.sex", target = "sex")
    @Mapping(source = "child.weight", target = "weight")
    @Mapping(source = "child.age", target = "age")
    @Mapping(source = "child.length", target = "length")
    @Mapping(source = "child.arrivalDate", target = "arrivalDate")
    @Mapping(source = "father", target = "father")
    @Mapping(source = "mother", target = "mother")
    AnimalDTO fromAnimals(Animal child, UUID father, UUID mother);

    default String fromUUID(UUID uuid) { return uuid.toString(); }

    default UUID fromUUID(String uuid) { return UUID.fromString(uuid); }
}
