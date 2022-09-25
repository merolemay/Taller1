package co.edu.icesi.ostrich_log.mapper;

import org.mapstruct.Mapper;

import co.edu.icesi.ostrich_log.dto.OstrichDTO;
import co.edu.icesi.ostrich_log.model.Ostrich;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OstrichMapper {
    Ostrich fromDTO(OstrichDTO ostrichDTO);

    OstrichDTO fromOstrich(Ostrich ostrich);

    Ostrich fromDTO(UUID ostrichId, OstrichDTO ostrichDTO);
}
