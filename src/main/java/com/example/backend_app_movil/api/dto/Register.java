package com.example.backend_app_movil.api.dto;
import com.example.backend_app_movil.model.IdUserType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "user")
public class Register {
    IdUserType idUserType;
    String name;
    String lastName;
    String phoneNumber;
    String mail;
    String password;
}
