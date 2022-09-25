package co.edu.icesi.apizoo.repository;

import co.edu.icesi.apizoo.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, UUID> {
}
