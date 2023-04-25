package com.example.backend_app_movil.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "setting")
public class File {

    @Id
   private String name;
   private String description;
   private String file;
   private String comment;
   private String qualification_level;
   private String cant_complaint;
   private String comment_complaint;
   private String userId;

}
