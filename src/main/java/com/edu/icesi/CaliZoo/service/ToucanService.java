package com.edu.icesi.CaliZoo.service;


import com.edu.icesi.CaliZoo.model.Toucan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ToucanService {

    public List<Toucan> getToucan(@PathVariable String toucanName);
    public Toucan createToucan(@RequestBody Toucan toucanDTO);
    public List<Toucan> getToucans();

}//End ToucanService