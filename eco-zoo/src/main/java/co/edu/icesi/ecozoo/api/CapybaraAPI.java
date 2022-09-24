package co.edu.icesi.ecozoo.api;

import co.edu.icesi.ecozoo.dto.AnimalResponseDTO;
import co.edu.icesi.ecozoo.dto.CapybaraDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/capybara")
public interface CapybaraAPI {

    @GetMapping("/{capybaraId}")
    public AnimalResponseDTO getAnimal(@PathVariable UUID capybaraId);

    @GetMapping("/name={capybaraName}")
    public AnimalResponseDTO getAnimalByName(@PathVariable String capybaraName);

    @PostMapping("")
    public CapybaraDTO createAnimal(@RequestBody CapybaraDTO capybaraDTO);

    @GetMapping("/all")
    public List<CapybaraDTO> getAnimals();
}
