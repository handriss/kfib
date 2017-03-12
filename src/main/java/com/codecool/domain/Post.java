package com.codecool.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Post {

    private Long id;
    private String title;
    private String body;
    private String teaser;
    private String slug;
    private Date postedOn;
    private Author author;

}
