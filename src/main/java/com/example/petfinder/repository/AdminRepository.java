package com.example.petfinder.repository;

import com.example.petfinder.model.user.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
