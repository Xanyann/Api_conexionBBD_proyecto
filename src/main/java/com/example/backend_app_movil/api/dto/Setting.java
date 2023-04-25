package com.example.backend_app_movil.api.dto;
import com.example.backend_app_movil.model.IdBlockingType;
import com.example.backend_app_movil.model.IdCalendarType;
import com.example.backend_app_movil.model.IdNotificationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "setting")
public class Setting {


    IdCalendarType idCalendarType;
    IdNotificationType idNotificationType;
    IdBlockingType idBlockingType;
    String userId;

}
