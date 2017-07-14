package com.codecool.model.dto;

import com.codecool.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {

    private Post post;

    private List<String> documentCategories;

    private List<String> targetAudienceCategories;

}
