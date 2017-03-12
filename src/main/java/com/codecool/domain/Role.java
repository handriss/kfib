package com.codecool.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="role")
@Slf4j
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    private Role(){}

    public Role(String name){
        this.name = name;
    }
}
