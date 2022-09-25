package co.edu.icesi.zoo.mapper;

import co.edu.icesi.zoo.dto.TatabroDTO;
import co.edu.icesi.zoo.dto.TatabroParentsDTO;
import co.edu.icesi.zoo.model.Tatabro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TatabroMapper {

    Tatabro fromDTO(TatabroDTO tatabroDTO);
    TatabroDTO fromTatabro(Tatabro tatabro);

    @Mapping(source = "child.id", target = "id")
    @Mapping(source = "child.name", target = "name")
    @Mapping(source = "child.sex", target = "sex")
    @Mapping(source = "child.weight", target = "weight")
    @Mapping(source = "child.height", target = "height")
    @Mapping(source = "child.age", target = "age")
    @Mapping(source = "child.arrivalDate", target = "arrivalDate")
    @Mapping(source = "father", target = "father")
    @Mapping(source = "mother", target = "mother")
    TatabroParentsDTO fromTatabroDTO(TatabroDTO child, TatabroDTO father, TatabroDTO mother);
}