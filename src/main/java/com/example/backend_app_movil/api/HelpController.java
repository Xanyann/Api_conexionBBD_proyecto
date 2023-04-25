package com.example.backend_app_movil.api;


import com.example.backend_app_movil.api.dto.Files;
import com.example.backend_app_movil.api.dto.Help;
import com.example.backend_app_movil.model.repository.FileRepository;
import com.example.backend_app_movil.model.repository.HelpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class HelpController {



  private final HelpRepository helpRepository;

  @PostMapping("Help")
  public ResponseEntity<String> saveUser(@RequestBody Help help) {
    try {
      helpRepository.save(help);
      System.out.println(help);
      return ResponseEntity.ok("Archivo guardado correctamente"+ help);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al registrar el archivo");
    }
  }
  


}
