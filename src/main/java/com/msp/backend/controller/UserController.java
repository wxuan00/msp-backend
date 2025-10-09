package com.msp.backend.controller;

import com.msp.backend.entity.User;
import com.msp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    /**
     * GET all users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * GET single user by ID
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID " + id));
    }

    /**
     * CREATE new user
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        // optional: assign default password or validation
        if (user.getUsername() == null || user.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and email are required.");
        }
        return repo.save(user);
    }

    /**
     * UPDATE user
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return repo.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            return repo.save(user);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID " + id));
    }

    /**
     * DELETE user
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID " + id);
        }
        repo.deleteById(id);
    }
}
