package backend.Ajimi.user.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import backend.Ajimi.user.entities.User;
import backend.Ajimi.user.services.UserService;

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
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @Tag(name = "get", description = "GET method returning list of users by given surname")
  @GetMapping("/surname")
  public List<User> getUserBySurname(@RequestBody String surname) {
    return userService.getUserBySurname(surname);
  }

  // Additional controller methods related to user operations can be added here
}
