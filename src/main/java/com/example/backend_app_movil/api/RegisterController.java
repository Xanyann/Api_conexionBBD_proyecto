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
  public ResponseEntity<Register> saveUser(@RequestBody Register register) {
    try {
      Register savedUser = registerRepository.save(register);
      System.out.println(savedUser);
      return ResponseEntity.ok(savedUser);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
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
