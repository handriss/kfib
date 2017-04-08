package com.codecool.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
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

    private String url;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadedOn;

    @ManyToMany(mappedBy = "files")
    private Set<Post> correspondingPosts;

    public File(){
        this.uploadedOn = new Timestamp(System.currentTimeMillis());
    }

    public File(String name, String url) {
        this.name = name;
        this.url = url;
        this.correspondingPosts = null;
        this.uploadedOn = new Timestamp(System.currentTimeMillis());
    }
}
