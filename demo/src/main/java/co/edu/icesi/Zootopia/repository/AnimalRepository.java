package co.edu.icesi.Zootopia.repository;


import co.edu.icesi.Zootopia.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, UUID> {
    Optional<Animal> findByName(String name);
}
