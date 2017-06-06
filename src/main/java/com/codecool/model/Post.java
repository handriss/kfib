package com.codecool.model;


import com.codecool.model.enums.DocumentCategory;
import com.codecool.model.enums.TargetAudienceCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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
    private String introduction;

    @Column(columnDefinition = "TEXT")
    private String body;

    @ElementCollection
    private List<DocumentCategory> documentCategories;

    @ElementCollection
    private List<TargetAudienceCategory> targetAudienceCategories;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_post", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="post_file", joinColumns = @JoinColumn(name="post_id"), inverseJoinColumns = @JoinColumn(name="file_id"))
    private Set<File> files;

    public Post(){}

    public Post(String title) {
        this.title = title;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }

    public Post(String title, String introduction, String body) {
        this.title = title;
        this.introduction = introduction;
        this.body = body;
        this.postedOn = new Timestamp(System.currentTimeMillis());
    }

    public void addDocumentCategory(DocumentCategory documentCategory){
        this.documentCategories.add(documentCategory);
    }

    public void removeDocumentCategory(DocumentCategory documentCategory){
        this.documentCategories.remove(documentCategory);
    }

    public void addTargetAudienceCategory(TargetAudienceCategory targetAudienceCategory){
        this.targetAudienceCategories.add(targetAudienceCategory);
    }

    public void removeTargetAudienceCategory(TargetAudienceCategory targetAudienceCategory){
        this.targetAudienceCategories.remove(targetAudienceCategory);
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
