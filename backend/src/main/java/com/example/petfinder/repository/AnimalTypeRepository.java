package com.example.petfinder.repository;

import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.animal.Attribute;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface AnimalTypeRepository extends CrudRepository<AnimalType, Long> {
}
