package com.example.backend_app_movil.model.repository;

import com.example.backend_app_movil.api.dto.Files;
import com.example.backend_app_movil.api.dto.Setting;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SettingRepository extends MongoRepository<Setting, String> {


}
