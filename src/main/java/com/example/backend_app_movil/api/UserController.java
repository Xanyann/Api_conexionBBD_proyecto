package com.example.backend_app_movil.api;

import com.example.backend_app_movil.api.dto.Login;
import com.example.backend_app_movil.model.User;
import com.example.backend_app_movil.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @PostMapping("login")
  public User login(@RequestBody Login login) throws AccessDeniedException {
    System.out.println(login);
    return userRepository
        .findByMailAndPassword(login.getMail(), login.getPassword())
        .orElseThrow(() -> new AccessDeniedException("Usuario no registrado"));
  }

}
