package com.msp.backend.service;

import com.msp.backend.entity.Role;
import com.msp.backend.entity.User;
import com.msp.backend.repository.RoleRepository;
import com.msp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepo;
    private final UserRepository userRepo;

    public RoleService(RoleRepository roleRepo, UserRepository userRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Transactional
    public void assignRolesToUser(Long userId, List<Role> roles) {
        User user = userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        
        // Make sure all roles exist in the database
        List<Role> validRoles = roleRepo.findAllById(
            roles.stream().map(Role::getId).toList()
        );
        
        user.getRoles().clear();
        user.getRoles().addAll(validRoles);
        userRepo.save(user);
    }
}
