package com.example.petfinder.repository;

import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.animal.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute, Long> {

    List<Attribute> findAllByAnimalTypes(AnimalType animalType);
}
