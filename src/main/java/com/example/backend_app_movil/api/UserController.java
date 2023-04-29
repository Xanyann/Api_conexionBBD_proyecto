package com.example.backend_app_movil.api;

import com.example.backend_app_movil.api.dto.Login;
import com.example.backend_app_movil.api.dto.Register;
import com.example.backend_app_movil.model.IdUserType;
import com.example.backend_app_movil.model.User;
import com.example.backend_app_movil.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

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

  @PostMapping("data")
  public User getUsuario(@RequestBody  Register data)  throws AccessDeniedException{
    System.out.println(data);

    return userRepository
            .findByMail(data.getMail())
            .orElseThrow(() -> new AccessDeniedException("Usuario no registrado"));
  }
  @PutMapping("update")
  public User updateUsuario(@RequestBody Register update) throws AccessDeniedException {
    System.out.println(update);

    Optional<User> optionalUser = userRepository.findByMail(update.getMail());
    User user = optionalUser.orElseThrow(() -> new AccessDeniedException("Usuario no registrado"));

    user.setName(update.getName());
    user.setLastName(update.getLastName());
    user.setPhoneNumber(update.getPhoneNumber());
    user.setPassword(update.getPassword());

    userRepository.save(user);

    return user;
  }




}
