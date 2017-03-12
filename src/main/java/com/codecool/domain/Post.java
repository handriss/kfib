package com.codecool.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TEXT")
    private String teaser;

    private String slug;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;

    @ManyToMany(mappedBy = "posts")
    private Set<User> users;

    private Post(){}

    public Post(String title, Set<User> users) {
        this.title = title;
        this.users = users;
    }

    public Post(String title) {
        this.title = title;
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
