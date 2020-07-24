package com.example.petfinder.repository;

import com.example.petfinder.model.shelter.Shelter;
import org.springframework.data.repository.CrudRepository;

public interface ShelterRepository extends CrudRepository<Shelter, Long> {
}
