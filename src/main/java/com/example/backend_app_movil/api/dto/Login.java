package com.example.backend_app_movil.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.util.BsonUtils;

@Data
public class Login {

    String mail;
    String password;
}
