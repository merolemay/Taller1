package com.edu.icesi.CaliZoo.repository;

import com.edu.icesi.CaliZoo.model.Toucan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ToucanRepository extends CrudRepository<Toucan, UUID> {
}
