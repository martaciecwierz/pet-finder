package com.example.petfinder.repository;

import com.example.petfinder.model.shelter.Shelter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShelterRepository extends CrudRepository<Shelter, Long> {

    List<Shelter> findByAddressCityContaining(String addressCity);
}
