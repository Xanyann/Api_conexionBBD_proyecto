package com.example.backend_app_movil.model.repository;

import com.example.backend_app_movil.api.dto.Files;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface FileRepository extends MongoRepository<Files, String> {


}
