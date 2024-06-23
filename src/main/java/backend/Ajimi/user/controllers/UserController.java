package backend.Ajimi.user.controllers;

import backend.Ajimi.user.entities.User;
import backend.Ajimi.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.saveUser(user);
    return ResponseEntity.ok(savedUser);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable UUID id) {
    return userService.findUserById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/search")
  public ResponseEntity<List<User>> getUsersByUsername(@RequestParam String username) {
    List<User> users = userService.findUsersByUsername(username);
    return ResponseEntity.ok(users);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }
}
