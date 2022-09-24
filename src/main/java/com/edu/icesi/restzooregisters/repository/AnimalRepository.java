package com.edu.icesi.restzooregisters.repository;

import com.edu.icesi.restzooregisters.model.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimalRepository extends CrudRepository<Animal, UUID> {
}
