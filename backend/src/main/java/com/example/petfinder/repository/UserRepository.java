package com.example.petfinder.repository;

import com.example.petfinder.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findByFirstNameContainsOrLastNameContainsAndActive_True(String firstName, String lastName);
    Optional<User> findByEmail(String email);
}
