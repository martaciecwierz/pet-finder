package com.example.petfinder.repository;

import com.example.petfinder.model.animal.AnimalImage;
import org.springframework.data.repository.CrudRepository;

public interface AnimalImageRepository extends CrudRepository<AnimalImage, Long> {
}
