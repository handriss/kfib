package com.codecool.service;


import com.codecool.domain.Role;
import com.codecool.domain.User;
import com.codecool.repository.RoleRepository;
import com.codecool.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class DataLoader {

    private UserService userService;

    private RoleService roleService;

    @Autowired
    public DataLoader(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }



    @PostConstruct
    public void loadData(){

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ADMIN"));
        roles.add(new Role("USER"));

        User user = new User("andrashinkel@gmail.com", "admin", roles);

        log.info("Postconstruct ran.");
    }
}
