package com.edu.icesi.conceptsreview.repository;

import com.edu.icesi.conceptsreview.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, UUID> {
}
