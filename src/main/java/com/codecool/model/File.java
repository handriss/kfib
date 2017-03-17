package com.codecool.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class File {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private byte[] data;

    @ManyToMany(mappedBy = "files")
    private Set<Post> correspondingPosts;

    private File(){}


}
