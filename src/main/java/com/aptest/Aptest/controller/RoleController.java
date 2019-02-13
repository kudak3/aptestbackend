package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.Role;
import com.aptest.Aptest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
