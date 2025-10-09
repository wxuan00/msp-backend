package com.msp.backend.service;

import com.msp.backend.entity.User;
import com.msp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
