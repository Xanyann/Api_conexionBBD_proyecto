package com.example.backend_app_movil.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "setting")
public class Help {

    @Id
   private IdCalendarType idCalendarType;
   private IdNotificationType idNotificationType;
   private IdBlockingType idBlockingType;
   private String userId;

}
