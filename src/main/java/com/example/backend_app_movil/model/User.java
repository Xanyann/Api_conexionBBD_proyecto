package com.example.backend_app_movil.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private IdUserType idUserType;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String password;

}
