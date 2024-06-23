package backend.Ajimi.user.services;

import backend.Ajimi.user.entities.User;
import backend.Ajimi.user.entities.UserDTO;
import backend.Ajimi.user.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Lazy
@Service
public class UserService {

    private final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
        return users;
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id.toString())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
