package com.example.backend_app_movil.api;


import com.example.backend_app_movil.api.dto.Files;
import com.example.backend_app_movil.api.dto.Setting;
import com.example.backend_app_movil.model.repository.FileRepository;
import com.example.backend_app_movil.model.repository.SettingRepository;
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
public class SettingController {



  private final SettingRepository settingRepository ;

  @PostMapping("Setting")
  public ResponseEntity<String> saveUser(@RequestBody Setting setting) {
    try {
      settingRepository.save(setting);
      System.out.println(setting);
      return ResponseEntity.ok("Archivo guardado correctamente"+ setting);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al registrar el archivo");
    }
  }
  


}
