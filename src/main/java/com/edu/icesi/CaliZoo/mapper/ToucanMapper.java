package com.edu.icesi.CaliZoo.mapper;

import com.edu.icesi.CaliZoo.dto.ToucanDTO;
import com.edu.icesi.CaliZoo.model.Toucan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToucanMapper {

    Toucan fromDTO(ToucanDTO toucanDTO);
    List<ToucanDTO> fromToucan(List<Toucan> toucan);
    ToucanDTO fromToucan(Toucan toucan);

}//End ToucanMapper
