package com.codecool.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


    @OneToMany
    @JoinTable(name="author_posts", joinColumns={@JoinColumn(name="author_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="dog_id", referencedColumnName="id")})
    private List<Post> posts;

    private Author(){}

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
