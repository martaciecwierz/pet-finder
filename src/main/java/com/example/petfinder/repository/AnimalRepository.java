package com.example.petfinder.repository;

import com.example.petfinder.model.animal.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
