package com.codecool.domain;


import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Entity
public class Role {

    private Long id;

    private String name;

    private Set<User> users;

    private Role(){}

    public Role(String name){
        this.name = name;
    }
}
