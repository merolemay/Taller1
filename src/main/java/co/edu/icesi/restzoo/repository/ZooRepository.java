package co.edu.icesi.restzoo.repository;

import co.edu.icesi.restzoo.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ZooRepository extends CrudRepository<Animal, UUID> {
    Optional<Animal> findByName(String name);
}
