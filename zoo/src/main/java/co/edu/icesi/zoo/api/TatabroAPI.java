package co.edu.icesi.zoo.api;

import co.edu.icesi.zoo.dto.TatabroDTO;
import co.edu.icesi.zoo.dto.TatabroParentsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.UUID;

@RequestMapping("/tatabros")
public interface TatabroAPI {

    @GetMapping("/id/{tatabroId}")
    TatabroDTO getTatabroByID(@PathVariable() UUID tatabroId);

    @GetMapping("/name/{tatabroName}")
    TatabroParentsDTO getTatabroByName(@PathVariable String tatabroName);

    @PostMapping()
    TatabroDTO createTatabro(@RequestBody TatabroDTO tatabroDTO) throws Exception;

    @GetMapping
    List<TatabroDTO> getTatabros();
}