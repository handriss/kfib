package com.codecool.domain;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="role")
@Slf4j
public class Role {

    @Id
    @GeneratedValue
    @Column(name="role_id", unique = true)
    private Long id;

    @Column(name="email")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    private Role(){}

    public Role(String name){
        this.name = name;
    }
}
