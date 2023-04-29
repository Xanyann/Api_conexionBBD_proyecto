package com.example.backend_app_movil.model.repository;

import com.example.backend_app_movil.model.IdUserType;
import com.example.backend_app_movil.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.util.BsonUtils;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByMailAndPassword(String mail,String password);
    Optional<User> findByMail(String mail);

}
