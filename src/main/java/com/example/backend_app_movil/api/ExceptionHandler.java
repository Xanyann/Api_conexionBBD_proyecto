package com.example.backend_app_movil.api;

import com.example.backend_app_movil.api.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
  public final ResponseEntity<ErrorMessage> handleAccessDeniedException(
      AccessDeniedException ex, WebRequest request) {
    ErrorMessage errorDetails =
        new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
  }

}
