package com.codecool.service;


import com.codecool.model.File;
import com.codecool.model.Post;
import com.codecool.model.Role;
import com.codecool.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private PostService postService;
    private BCryptPasswordEncoder passwordEncoder;
    private FileService fileService;

    @Autowired
    public DataLoader(UserService userService, RoleService roleService, PostService postService, BCryptPasswordEncoder passwordEncoder, FileService fileService) {
        this.userService = userService;
        this.roleService = roleService;
        this.postService = postService;
        this.passwordEncoder = passwordEncoder;
        this.fileService = fileService;
    }


    @PostConstruct
    public void loadData(){

        File file1 = new File("picture01", "https://www.google.hu/");
        File file2 = new File("picture02", "https://www.google.hu/");
        File file3 = new File("picture03", "https://www.google.hu/");

        fileService.save(file1);
        fileService.save(file2);
        fileService.save(file3);


        Set<Role> roles = new HashSet<>();
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.save(adminRole);
        roleService.save(userRole);

        roles.add(adminRole);
        roles.add(userRole);

        Set<Post> posts = new HashSet<>();
        Post post1 = new Post("Kockásfülű nyúl");
        Post post2 = new Post("Lola és bolka");
        Post post3 = new Post("Lola és bolka");

        postService.save(post1);
        postService.save(post2);
        postService.save(post3);


        posts.add(post1);
        posts.add(post2);

        User user = new User("admin@admin.com",  passwordEncoder.encode("admin"), roles, posts);

        userService.save(user);
    }
}
