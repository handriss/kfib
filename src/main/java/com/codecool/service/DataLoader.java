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
    public DataLoader(FileService fileService, PostService postService, UserService userService, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.postService = postService;
        this.fileService = fileService;
    }



    @PostConstruct
    public void loadData(){

        File file1 = new File("picture01");
        File file2 = new File("picture02");
        File file3 = new File("picture03");
        File file4 = new File("picture04");
        File file5 = new File("picture05");
        File file6 = new File("picture06");
        File file7 = new File("picture07");
        File file8 = new File("picture08");
        File file9 = new File("picture09");
        File file10 = new File("picture10");
        File file11 = new File("picture11");
        File file12 = new File("picture12");
        File file13 = new File("picture13");
        File file14 = new File("picture14");
        File file15 = new File("picture15");

        fileService.save(file1);
        fileService.save(file2);
        fileService.save(file3);
        fileService.save(file4);
        fileService.save(file5);
        fileService.save(file6);
        fileService.save(file7);
        fileService.save(file8);
        fileService.save(file9);
        fileService.save(file10);
        fileService.save(file11);
        fileService.save(file12);
        fileService.save(file13);
        fileService.save(file14);
        fileService.save(file15);


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
        Post post4 = new Post("Lola és bolka");
        Post post5 = new Post("Lola és bolka");
        Post post6 = new Post("Lola és bolka");
        Post post7 = new Post("Lola és bolka");
        Post post8 = new Post("Lola és bolka");
        Post post9 = new Post("Lola és bolka");
        Post post10 = new Post("Lola és bolka");
        Post post11 = new Post("Lola és bolka");
        Post post12 = new Post("Lola és bolka");
        Post post13 = new Post("Lola és bolka");
        Post post14 = new Post("Lola és bolka");
        Post post15 = new Post("Lola és bolka");

        postService.save(post1);
        postService.save(post2);
        postService.save(post3);
        postService.save(post4);
        postService.save(post5);
        postService.save(post6);
        postService.save(post7);
        postService.save(post8);
        postService.save(post9);
        postService.save(post10);
        postService.save(post11);
        postService.save(post12);
        postService.save(post13);
        postService.save(post14);
        postService.save(post15);

        posts.add(post1);
        posts.add(post2);

        User user = new User("admin@admin.com",  passwordEncoder.encode("admin"), roles, posts);

        userService.save(user);
    }
}
