package com.example.petfinder.repository;

import com.example.petfinder.model.action.Action;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends CrudRepository<Action, Long> {
}
