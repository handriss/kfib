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

        fileService.save(file1);
        fileService.save(file2);

        Set<Role> roles = new HashSet<>();
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.save(adminRole);
        roleService.save(userRole);

        roles.add(adminRole);
        roles.add(userRole);

        Set<Post> posts = new HashSet<>();
        Post post1 = new Post("A 2017. évi költségvetési törvény és a középtávú pálya értékelése (2016-20)", "Jelen elemzés a Költségvetési Felelősségi Intézet kiadványaként, jelentős részben önkéntesek munkájával készült és – az azóta elkészült anyagok Módszertani Függelékeiben leírt eltérésektől eltekintve – a 2010 végén megszüntetett Költségvetési Tanács Titkárságán kidolgozott módszertanokra támaszkodik. Jelen tanulmány célzat és részrehajlás nélkül bemutatja a gazdasági folyamatok és a 2016. június 14- ig kihirdetett, vagy a parlament által elfogadott jogszabályok alapján kirajzolódó középtávú makrogazdasági és költségvetési pályát.");
        Post post2 = new Post("A 2017. évi költségvetési törvény és a középtávú pálya értékelése (2016-20)", "Jelen elemzés a Költségvetési Felelősségi Intézet kiadványaként, jelentős részben önkéntesek munkájával készült és – az azóta elkészült anyagok Módszertani Függelékeiben leírt eltérésektől eltekintve – a 2010 végén megszüntetett Költségvetési Tanács Titkárságán kidolgozott módszertanokra támaszkodik. Jelen tanulmány célzat és részrehajlás nélkül bemutatja a gazdasági folyamatok és a 2016. június 14- ig kihirdetett, vagy a parlament által elfogadott jogszabályok alapján kirajzolódó középtávú makrogazdasági és költségvetési pályát.");
        Post post3 = new Post("A 2017. évi költségvetési törvény és a középtávú pálya értékelése (2016-20)", "Jelen elemzés a Költségvetési Felelősségi Intézet kiadványaként, jelentős részben önkéntesek munkájával készült és – az azóta elkészült anyagok Módszertani Függelékeiben leírt eltérésektől eltekintve – a 2010 végén megszüntetett Költségvetési Tanács Titkárságán kidolgozott módszertanokra támaszkodik. Jelen tanulmány célzat és részrehajlás nélkül bemutatja a gazdasági folyamatok és a 2016. június 14- ig kihirdetett, vagy a parlament által elfogadott jogszabályok alapján kirajzolódó középtávú makrogazdasági és költségvetési pályát.");
        Post post4 = new Post("A 2017. évi költségvetési törvény és a középtávú pálya értékelése (2016-20)", "Jelen elemzés a Költségvetési Felelősségi Intézet kiadványaként, jelentős részben önkéntesek munkájával készült és – az azóta elkészült anyagok Módszertani Függelékeiben leírt eltérésektől eltekintve – a 2010 végén megszüntetett Költségvetési Tanács Titkárságán kidolgozott módszertanokra támaszkodik. Jelen tanulmány célzat és részrehajlás nélkül bemutatja a gazdasági folyamatok és a 2016. június 14- ig kihirdetett, vagy a parlament által elfogadott jogszabályok alapján kirajzolódó középtávú makrogazdasági és költségvetési pályát.");
        Post post5 = new Post("A 2017. évi költségvetési törvény és a középtávú pálya értékelése (2016-20)", "Jelen elemzés a Költségvetési Felelősségi Intézet kiadványaként, jelentős részben önkéntesek munkájával készült és – az azóta elkészült anyagok Módszertani Függelékeiben leírt eltérésektől eltekintve – a 2010 végén megszüntetett Költségvetési Tanács Titkárságán kidolgozott módszertanokra támaszkodik. Jelen tanulmány célzat és részrehajlás nélkül bemutatja a gazdasági folyamatok és a 2016. június 14- ig kihirdetett, vagy a parlament által elfogadott jogszabályok alapján kirajzolódó középtávú makrogazdasági és költségvetési pályát.");

        postService.save(post1);
        postService.save(post2);
        postService.save(post3);
        postService.save(post4);
        postService.save(post5);

        posts.add(post1);
        posts.add(post2);

        User user = new User("admin@admin.com",  passwordEncoder.encode("admin"), roles, posts);

        userService.save(user);
    }
}
