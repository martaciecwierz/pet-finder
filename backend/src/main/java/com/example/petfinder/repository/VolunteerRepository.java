package com.example.petfinder.repository;

import com.example.petfinder.model.user.Volunteer;
import org.springframework.data.repository.CrudRepository;

public interface VolunteerRepository extends CrudRepository<Volunteer, Long> {
}
