package com.edu.icesi.CaliZoo.service.impl;

import com.edu.icesi.CaliZoo.constants.ToucanProperties;
import com.edu.icesi.CaliZoo.model.Toucan;
import com.edu.icesi.CaliZoo.repository.ToucanRepository;
import com.edu.icesi.CaliZoo.service.ToucanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ToucanServiceImpl implements ToucanService {

    public final ToucanRepository toucanRepository;

    @Override
    public List<Toucan> getToucan(String toucanName) {
        Toucan ChosenToucan = getToucans().stream().filter(toucan->toucan.getName().equalsIgnoreCase(toucanName))
                .findFirst().get();
        return getToucanParents(ChosenToucan);
    }//End getToucan

    @Override
    public Toucan createToucan(Toucan toucanDTO) {
        if(toucanDTO == null)
            throw new RuntimeException();
        thereIsToucanWithName(toucanDTO.getName());
        validateSexInBounds(toucanDTO.getSex());
        validateParentsSex(toucanDTO.getMotherId(),toucanDTO.getFatherId());
        return toucanRepository.save(toucanDTO);
    }//End createToucan

    @Override
    public List<Toucan> getToucans() {
        return StreamSupport.stream(toucanRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    private void thereIsToucanWithName(final String toucanName){
        try{
            getToucans().stream().filter(toucan->toucan.getName().equalsIgnoreCase(toucanName)).findFirst().get();
            throw new RuntimeException();
        }catch (NoSuchElementException e){System.out.println("No existe un tucan con ese nombre :)");}
    }//End thereIsToucanWithName

    private void validateSexInBounds(final String toucanSex){
        if(!toucanSex.toUpperCase().matches("(F|M)"))
            throw new RuntimeException();
    }//End checkSex

    private void validateParentsSex(UUID motherId, UUID fatherId){
        if(motherId != null){
            Optional<Toucan> mother = toucanRepository.findById(motherId);
            if(!mother.get().getSex().toUpperCase().matches("F"))
                throw new RuntimeException();
        }//End if
        if(fatherId != null){
            Optional<Toucan> father = toucanRepository.findById(fatherId);
            if(!father.get().getSex().toUpperCase().matches("M"))
                throw new RuntimeException();
        }//End if
    }//End validateParentsSex

    private List<Toucan> getToucanParents(Toucan toucan){
        List<Toucan> toucanAndParents = new ArrayList<>();
        toucanAndParents.add(toucan);
        UUID fatherId = toucan.getFatherId();
        UUID motherId = toucan.getMotherId();
        if(fatherId != null ) toucanAndParents.add(toucanRepository.findById(fatherId).orElse(null));
        if(motherId != null ) toucanAndParents.add(toucanRepository.findById(motherId).orElse(null));
        return toucanAndParents;
    }//End getToucanParents
}//End ToucanServiceImpl
