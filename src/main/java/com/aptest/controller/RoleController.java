package com.aptest.controller;

import com.aptest.document.Role;
import com.aptest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleRepository.findAll();

    }

    @GetMapping("/role/{name}")
    public Role getOneRole(@PathVariable String name){
        return roleRepository.findRoleByName(name);
    }

    @PostMapping("/role")
    public Role addRole(@RequestBody Role role){
        return roleRepository.save(role);
    }
}
