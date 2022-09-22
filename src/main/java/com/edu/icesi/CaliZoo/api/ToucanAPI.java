package com.edu.icesi.CaliZoo.api;

import com.edu.icesi.CaliZoo.dto.ToucanDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/toucans")
public interface ToucanAPI {

    @GetMapping("/{toucanId}")
    public ToucanDTO getToucan(@PathVariable UUID toucanId);

    @PostMapping()
    public ToucanDTO createToucan(@RequestBody ToucanDTO toucanDTO);

    @GetMapping
    public List<ToucanDTO> getToucans();

}//End ToucanAPI
