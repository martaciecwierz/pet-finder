package com.example.petfinder.repository;

import com.example.petfinder.model.request.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
