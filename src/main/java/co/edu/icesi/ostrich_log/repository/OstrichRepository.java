package co.edu.icesi.ostrich_log.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.ostrich_log.model.Ostrich;

import java.util.UUID;

@Repository
public interface OstrichRepository extends CrudRepository<Ostrich, UUID> {
	
}
