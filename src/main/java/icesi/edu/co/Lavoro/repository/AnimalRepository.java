package icesi.edu.co.Lavoro.repository;

import icesi.edu.co.Lavoro.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, UUID> {
    public Optional<Animal> findByName(String name);

}
