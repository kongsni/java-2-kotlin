package me.jko.java2kotlin;

import me.jko.java2kotlin.User;
import me.jko.java2kotlin.UserCreateRequest;
import me.jko.java2kotlin.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // c
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(
                userCreateRequest.getName(),
                userCreateRequest.getEmail()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // r
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // u
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUsername(@PathVariable Long id, @RequestParam String updateName) {
        User user = userService.updateUsername(id, updateName);

        return ResponseEntity.ok(user);
    }
}