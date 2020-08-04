package com.example.petfinder.repository;

import com.example.petfinder.model.request.RequestType;
import org.springframework.data.repository.CrudRepository;

public interface RequestTypeRepository extends CrudRepository<RequestType, Long> {
}
