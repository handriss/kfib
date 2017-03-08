package com.codecool.service;


import com.codecool.domain.Role;
import com.codecool.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@Transactional
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
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleService.save(adminRole);

        roles.add(adminRole);
        roles.add(userRole);

        User user = new User("andrashinkel@gmail.com", "admin", roles);

        log.info("Postconstruct ran.");
        log.info(user.toString());

//        userService.save(user);
    }
}
