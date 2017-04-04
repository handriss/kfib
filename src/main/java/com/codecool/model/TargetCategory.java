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
@Table(name="targetCategories")
public class TargetCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "targetCategories")
    @JsonIgnore
    private Set<Post> posts;

    private TargetCategory(){}

    public TargetCategory(String name){
        this.name = name;
    }

}
