package com.edu.icesi.CaliZoo.controller;

import com.edu.icesi.CaliZoo.api.ToucanAPI;
import com.edu.icesi.CaliZoo.dto.ToucanDTO;
import com.edu.icesi.CaliZoo.mapper.ToucanMapper;
import com.edu.icesi.CaliZoo.service.ToucanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class ToucanController implements ToucanAPI {

    private final ToucanService toucanService;
    private final ToucanMapper toucanMapper;

    @Override
    public List<ToucanDTO> getToucan(UUID toucanId) {
        return toucanMapper.fromToucan(toucanService.getToucan(toucanId));
    }

    @Override
    public ToucanDTO createToucan(@Valid ToucanDTO toucanDTO) {
        if(toucanDTO == null)
            throw new RuntimeException();
        verifyNameConstrains(toucanDTO.getName());
        verifyArrivalDate(toucanDTO.getDateOfArrival());
        return toucanMapper.fromToucan(toucanService.createToucan(toucanMapper.fromDTO(toucanDTO)));
    }

    @Override
    public List<ToucanDTO> getToucans() {
        return toucanService.getToucans().stream().map(toucanMapper::fromToucan).collect(Collectors.toList());
    }

    private void verifyNameConstrains(final String toucanName){
        if(toucanName.matches("([^A-Za-z ])"))
            throw new RuntimeException();
    }//End verifyNameConstrains

    private void verifyArrivalDate(LocalDate arrivalDate){
       if(arrivalDate == null || arrivalDate.compareTo(LocalDate.now()) > 0)
           throw new RuntimeException();
    }//End verifyArrivalDate
}//End ToucanController
