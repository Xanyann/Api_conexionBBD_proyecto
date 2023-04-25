package com.example.backend_app_movil.api;

import com.example.backend_app_movil.api.dto.Register;
import com.example.backend_app_movil.model.User;
import com.example.backend_app_movil.model.repository.RegisterRepository;
import com.example.backend_app_movil.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class RegisterController {



  private final RegisterRepository registerRepository;
  private final UserRepository userRepository;

  @PostMapping("register")
  public ResponseEntity<String> saveUser(@RequestBody Register register) {
    try {
      registerRepository.save(register);
      System.out.println(register);
      return ResponseEntity.ok("Usuario registrado correctamente");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al registrar el usuario");
    }
  }
/*
    @GetMapping("/{id}")
    public User getUsuario(@PathVariable String id) {
      System.out.println(id);
      return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUsuario(@PathVariable String id, @RequestBody User usuario) {
      usuario.setId(id);
      return userRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) {
      userRepository.deleteById(id);
    }
*/




  }
