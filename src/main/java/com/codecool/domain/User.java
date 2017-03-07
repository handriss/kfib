package com.codecool.domain;


import java.util.Set;


public class User {

    private Long id;

    private String email;

    private String password;

    private Set<Role> roles;

    private User(){}

    public User(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
