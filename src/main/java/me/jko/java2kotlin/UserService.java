package me.jko.java2kotlin;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    //Dependency Injection
    //Inversion of control
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
