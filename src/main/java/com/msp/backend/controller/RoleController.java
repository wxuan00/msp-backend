package com.msp.backend.controller;

import com.msp.backend.entity.Role;
import com.msp.backend.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping("/{userId}")
    public void assignRolesToUser(@PathVariable Long userId, @RequestBody List<Role> roles) {
        roleService.assignRolesToUser(userId, roles);
    }
}
