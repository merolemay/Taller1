package com.edu.icesi.CaliZoo.service.impl;

import com.edu.icesi.CaliZoo.constants.ToucanProperties;
import com.edu.icesi.CaliZoo.model.Toucan;
import com.edu.icesi.CaliZoo.repository.ToucanRepository;
import com.edu.icesi.CaliZoo.service.ToucanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ToucanServiceImpl implements ToucanService {

    public final ToucanRepository toucanRepository;

    @Override
    public Toucan getToucan(UUID toucanId) {
        return toucanRepository.findById(toucanId).orElse(null);
    }

    @Override
    public Toucan createToucan(Toucan toucanDTO) {
        if(toucanDTO == null)
            throw new RuntimeException();
        verifyValueInBounds(toucanDTO.getWeight(),ToucanProperties.MAX_WEIGHT.getValue(),ToucanProperties.MIN_WEIGHT.getValue());
        verifyValueInBounds(toucanDTO.getHeight(),ToucanProperties.MAX_HEIGHT.getValue(),ToucanProperties.MIN_HEIGHT.getValue());
        verifyValueInBounds(toucanDTO.getAge(),ToucanProperties.MAX_AGE.getValue(),ToucanProperties.MIN_AGE.getValue());
        return toucanRepository.save(toucanDTO);
    }

    @Override
    public List<Toucan> getToucans() {
        return StreamSupport.stream(toucanRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    private void verifyValueInBounds(double value,final double MAX_WEIGHT,final double MIN_WEIGHT){
        if( value < MIN_WEIGHT || value > MAX_WEIGHT)
            throw new RuntimeException();
    }//End verifyValue
}//End ToucanServiceImpl
