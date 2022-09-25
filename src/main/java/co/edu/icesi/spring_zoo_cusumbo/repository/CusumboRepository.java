package co.edu.icesi.spring_zoo_cusumbo.repository;

import co.edu.icesi.spring_zoo_cusumbo.model.Cusumbo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CusumboRepository extends CrudRepository<Cusumbo, UUID> {

    public Optional<Cusumbo> findByName(String name);

}
