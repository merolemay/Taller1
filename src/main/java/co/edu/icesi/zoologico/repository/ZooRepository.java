package co.edu.icesi.zoologico.repository;

import co.edu.icesi.zoologico.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ZooRepository extends CrudRepository<Animal, UUID> {

}
