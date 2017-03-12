package com.codecool.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="users")
@Slf4j
public class User {

    @Id
    @Column(name="user_id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="user_post", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Post> posts;

    private User(){}

    public User(String email, String password, Set<Role> roles, Set<Post> posts) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.posts = posts;
    }

    public User(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

//    public void addPost(Post post){
//        this.posts.add(post);
//    }
}
