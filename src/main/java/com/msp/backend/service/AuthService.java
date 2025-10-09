package com.msp.backend.service;

import com.msp.backend.entity.User;
import com.msp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Store for active tokens (in production, use Redis or similar)
    private final Map<String, String> activeTokens = new ConcurrentHashMap<>();

    public ResponseEntity<?> login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        
        if (userOpt.isPresent() && password.equals(userOpt.get().getPassword())) {
            String token = generateToken();
            activeTokens.put(token, username);
            
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("username", username);            
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.badRequest().body(Map.of("message", "Invalid credentials"));
    }

    public void logout(String token) {
        activeTokens.remove(token);
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    public boolean validateToken(String token) {
        return activeTokens.containsKey(token);
    }
}