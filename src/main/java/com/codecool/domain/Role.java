package com.codecool.domain;


import java.util.Set;

public class Role {

    private Long id;

    private String name;

    private Set<User> users;

    private Role(){}

    public Role(String name){
        this.name = name;
    }
}
