package com.example.backend_app_movil.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorMessage {

  private Date date;
  private String message;
  private String description;
}
