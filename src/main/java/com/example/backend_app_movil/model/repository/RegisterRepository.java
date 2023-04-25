package com.example.backend_app_movil.model.repository;

import com.example.backend_app_movil.api.dto.Register;
import com.example.backend_app_movil.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RegisterRepository extends MongoRepository<Register, String> {


}
