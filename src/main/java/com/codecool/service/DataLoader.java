package com.codecool.service;


import com.codecool.model.*;
import com.codecool.model.enums.PostCategoryEnum;
import com.codecool.model.enums.TargetCategoryEnum;
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
    private PostCategoryService postCategoryService;
    private TargetCategoryService targetCategoryService;

    @Autowired
    public DataLoader(TargetCategoryService targetCategoryService, UserService userService, RoleService roleService, PostService postService, BCryptPasswordEncoder passwordEncoder, FileService fileService, PostCategoryService postCategoryService) {
        this.userService = userService;
        this.roleService = roleService;
        this.postService = postService;
        this.passwordEncoder = passwordEncoder;
        this.fileService = fileService;
        this.postCategoryService = postCategoryService;
        this.targetCategoryService = targetCategoryService;
    }


    @PostConstruct
    public void enumLoader(){

        for(PostCategoryEnum category : PostCategoryEnum.values()){
            postCategoryService.save(new PostCategory(category.getName()));
        }

        for(TargetCategoryEnum category : TargetCategoryEnum.values()){
            targetCategoryService.save(new TargetCategory(category.getName()));
        }

//        for(TargetCategoryEnum category : TargetCategoryEnum.values()){
//            targetCategoryService.save(new TargetCategory(category.getName()));
//        }

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
