package co.icesi.edu.animals.api;

import co.icesi.edu.animals.dto.CaripiareAndParentsDTO;
import co.icesi.edu.animals.dto.CaripiareDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/caripiares")
public interface CaripiareAPI {

    @PostMapping()
    public CaripiareDTO createCaripiare(@RequestBody CaripiareDTO caripiareDTO);

    @GetMapping("/{caripiareId}")
    public CaripiareDTO getCaripiare(@PathVariable UUID caripiareId);

    @GetMapping
    public List<CaripiareDTO> getCaripiares();

    @PostMapping("/{caripiareId}")
    public CaripiareDTO updateCaripiare(@PathVariable UUID caripiareId, @RequestBody CaripiareDTO caripiareDTO);

    @GetMapping("/{caripiareName}")
    public CaripiareAndParentsDTO getCaripiareAndParents(@PathVariable String name);

}
