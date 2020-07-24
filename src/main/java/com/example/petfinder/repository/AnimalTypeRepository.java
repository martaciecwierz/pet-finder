package com.example.petfinder.repository;

import com.example.petfinder.model.animal.AnimalType;
import org.springframework.data.repository.CrudRepository;

public interface AnimalTypeRepository extends CrudRepository<AnimalType, Long> {
}
