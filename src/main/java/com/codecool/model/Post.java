package com.codecool.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
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

    //    @ElementCollection
//    @CollectionTable(name = "employee_courses", joinColumns = @JoinColumn(name = "idemployee"))
//    private Set<Course> courses = new HashSet<Course>();

    @ElementCollection
    private Set<DocumentCategoryTag> documentCategoryTags = new HashSet<>();

    @ElementCollection
    private Set<TargetAudienceCategoryTag> targetAudienceCategoryTags = new HashSet<>();

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_post", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="post_file", joinColumns = @JoinColumn(name="post_id"), inverseJoinColumns = @JoinColumn(name="file_id"))
    private Set<File> files;

    public Post(){
    }

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



    public void addDocumentCategory(DocumentCategoryTag documentCategoryTag){
        this.documentCategoryTags.add(documentCategoryTag);
    }

    public void removeDocumentCategory(DocumentCategoryTag documentCategoryTag){
        this.documentCategoryTags.remove(documentCategoryTag);
    }

    public void addTargetAudienceCategory(TargetAudienceCategoryTag targetAudienceCategoryTag){
        this.targetAudienceCategoryTags.add(targetAudienceCategoryTag);
    }

    public void removeTargetAudienceCategory(TargetAudienceCategoryTag targetAudienceCategoryTag){
        this.targetAudienceCategoryTags.remove(targetAudienceCategoryTag);
    }

    public void addUser(User user){
        this.users.add(user);
    }

}
