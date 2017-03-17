package com.codecool.domain;


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

    public Post(){}

//    public Post(String title, Set<User> users) {
//        this.title = title;
//        this.users = users;
//    }

    public Post(String title) {
        this.title = title;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
