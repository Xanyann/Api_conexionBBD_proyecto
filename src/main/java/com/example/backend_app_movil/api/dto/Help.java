package com.example.backend_app_movil.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "help")
public class Help {
    String attached_question;
    String attached_answer;
    String question;
    String answer;
    String userId;
}
