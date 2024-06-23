package backend.Magazyn.user.controllers;

import backend.Magazyn.user.entities.UserDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import backend.Magazyn.user.entities.User;
import backend.Magazyn.user.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Tag(name = "post", description = "POST method for creating user")
  @PostMapping("/add")
  public User addUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @Tag(name = "get", description = "GET method returning list of users")
  @GetMapping("/all")
  public List<UserDTO> getAllUsers() {
    List<UserDTO> users = userService.getAllUsers();
    return userService.getAllUsers();
  }

  }

  // Additional controller methods related to user operations can be added here

