package me.jko.java2kotlin;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    //Dependency Injection
    //Inversion of control
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //C
    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);
    }

    //R
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    //U
    public User updateUsername(Long id, String updateName) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updateName);

        return userRepository.save(user);
    }

    //D
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
