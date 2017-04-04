package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Slf4j
@Entity
@Table(name="post_category")
public class PostCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "postCategories")
    @JsonIgnore
    private Set<Post> posts;

    private PostCategory(){}

    public PostCategory(String name){
        this.name = name;
    }
}
