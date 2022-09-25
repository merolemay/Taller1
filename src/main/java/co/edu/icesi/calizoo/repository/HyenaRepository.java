package co.edu.icesi.calizoo.repository;

import co.edu.icesi.calizoo.model.Hyena;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HyenaRepository extends CrudRepository<Hyena, UUID> {
}
