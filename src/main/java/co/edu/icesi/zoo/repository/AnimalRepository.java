package co.edu.icesi.zoo.repository;

import co.edu.icesi.zoo.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, UUID> {

    Optional<Animal> findById(String email);

    Optional<Animal> findByName(String name);

}
