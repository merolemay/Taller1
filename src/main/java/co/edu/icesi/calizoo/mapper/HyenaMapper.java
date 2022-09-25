package co.edu.icesi.calizoo.mapper;

import co.edu.icesi.calizoo.dto.HyenaDTO;
import co.edu.icesi.calizoo.model.Hyena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HyenaMapper {

    Hyena fromDTO (HyenaDTO hyenaDTO);

    HyenaDTO fromHyena(Hyena hyena);
}
