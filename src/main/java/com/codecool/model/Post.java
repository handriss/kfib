package com.codecool.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;

    @ManyToMany(mappedBy = "posts")
    @JsonIgnore
    private Set<User> users;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="post_file", joinColumns = @JoinColumn(name="post_id"), inverseJoinColumns = @JoinColumn(name="file_id"))
    private Set<File> files;

    public Post(){}


    public Post(String title) {
        this.title = title;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
