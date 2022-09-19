package co.edu.icesi.zoo.api;

import co.edu.icesi.zoo.model.Animal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/animals")
public interface AnimalAPI {

    @PostMapping()
    Animal createAnimal(@RequestBody Animal animal);
}
