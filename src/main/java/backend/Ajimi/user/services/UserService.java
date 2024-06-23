package backend.Ajimi.user.services;

import backend.Ajimi.user.entities.User;
import backend.Ajimi.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id.toString());
    }

    public List<User> findUsersByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id.toString());
    }
}
