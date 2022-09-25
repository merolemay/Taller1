package co.edu.icesi.zoo.repository;

import co.edu.icesi.zoo.model.Tatabro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TatabroRepository extends CrudRepository<Tatabro, UUID> {
    Optional<Tatabro> findByName(String tatabroName);
}