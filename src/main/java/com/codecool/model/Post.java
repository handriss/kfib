package com.codecool.model;


import com.codecool.model.enums.PostCategoryEnum;
import com.codecool.model.enums.TargetCategoryEnum;
import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Slf4j
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

    private ArrayList<PostCategoryEnum> postCategories;

    private ArrayList<TargetCategoryEnum> targetCategories;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_post", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="post_file", joinColumns = @JoinColumn(name="post_id"), inverseJoinColumns = @JoinColumn(name="file_id"))
    private Set<File> files;

    private Boolean isActive;

    public Post(){
        this.isActive = false;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }

    public Post(String title) {
        this.isActive = false;
        this.title = title;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }
}
