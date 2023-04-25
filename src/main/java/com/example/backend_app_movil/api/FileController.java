package com.example.backend_app_movil.api;


import com.example.backend_app_movil.api.dto.Files;
import com.example.backend_app_movil.model.repository.FileRepository;
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
public class FileController {



  private final FileRepository fileRepository;

  @PostMapping("Files")
  public ResponseEntity<String> saveUser(@RequestBody Files files) {
    try {
      fileRepository.save(files);
      System.out.println(files);
      return ResponseEntity.ok("Archivo guardado correctamente"+ files);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al registrar el archivo");
    }
  }
  


}
