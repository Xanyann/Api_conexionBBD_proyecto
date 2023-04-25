package com.example.backend_app_movil.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "file")
public class Files {
    String name;
    String description;
    String file;
    String comment;
    String qualification_level;
    String cant_complaint;
    String comment_complaint;
    String userId;

}
