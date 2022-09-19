package co.edu.icesi.zoo.repository;

import co.edu.icesi.zoo.constant.AnimalGender;
import co.edu.icesi.zoo.model.Animal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration()
@ExtendWith(SpringExtension.class)
public class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        Animal animal = Animal.builder().name("Lucas").sex(AnimalGender.M).age(10).height(12).weight(150).arrivalDate(Date.valueOf(LocalDate.now())).build();
        animalRepository.save(animal);
        Animal animals = Animal.builder().name("Lu").sex(AnimalGender.M).age(10).height(12).weight(150).arrivalDate(Date.valueOf(LocalDate.now())).father_id(UUID.randomUUID()).build();
        animalRepository.save(animals);
        List<Animal> a = (List<Animal>) animalRepository.findAll();

        assertThat(a.size()).isEqualTo(2);
    }

}
