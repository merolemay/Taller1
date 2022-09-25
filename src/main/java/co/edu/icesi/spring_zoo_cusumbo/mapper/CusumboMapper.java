package co.edu.icesi.spring_zoo_cusumbo.mapper;

import co.edu.icesi.spring_zoo_cusumbo.dto.CusumboDTO;
import co.edu.icesi.spring_zoo_cusumbo.model.Cusumbo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CusumboMapper {

    Cusumbo fromDTO(CusumboDTO cusumboDTO);

    CusumboDTO fromCusumbo(Cusumbo cusumbo);
}
