package com.example.petfinder.repository;

import com.example.petfinder.model.animal.AnimalAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalAttributeRepository extends CrudRepository<AnimalAttribute, Long> {

}
