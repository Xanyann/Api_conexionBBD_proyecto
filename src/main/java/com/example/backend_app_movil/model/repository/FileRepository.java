package com.example.backend_app_movil.model.repository;

import com.example.backend_app_movil.api.dto.Files;

import com.example.backend_app_movil.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FileRepository extends MongoRepository<Files, String> {

    Optional<Files> findByName (String name);
    @Query("{'name': {$regex : ?0}}")
    List<Files>  findAllByNameRegex(String name);
}
