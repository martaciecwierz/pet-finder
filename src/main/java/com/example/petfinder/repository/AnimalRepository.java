package com.example.petfinder.repository;

import com.example.petfinder.model.animal.Animal;
import com.example.petfinder.model.animal.AnimalType;
import com.example.petfinder.model.shelter.Shelter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    List<Animal> findByAnimalType(AnimalType animalType);

    List<Animal> findByShelter(Shelter shelter);
}
