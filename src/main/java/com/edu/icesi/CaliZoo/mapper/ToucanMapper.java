package com.edu.icesi.CaliZoo.mapper;

import com.edu.icesi.CaliZoo.dto.ToucanDTO;
import com.edu.icesi.CaliZoo.model.Toucan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToucanMapper {

    Toucan fromDTO(ToucanDTO toucanDTO);
    ToucanDTO fromToucan(Toucan toucan);

}//End ToucanMapper
