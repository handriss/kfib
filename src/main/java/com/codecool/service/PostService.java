package com.codecool.service;


import com.codecool.model.DocumentCategoryTag;
import com.codecool.model.Post;
import com.codecool.model.TargetAudienceCategoryTag;
import com.codecool.model.dto.PostDto;
import com.codecool.model.enums.DocumentCategory;
import com.codecool.model.enums.TargetAudienceCategory;
import com.codecool.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        post.setPostedOn(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
    }

    public void save(PostDto postDto){
        postDto.getPost().setPostedOn(new Timestamp(System.currentTimeMillis()));

        Set<DocumentCategoryTag> documentCategoryTags = new HashSet<>();

        for(String currentTag : postDto.getDocumentCategories()){
            if(currentTag.equals("transparency")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.transparency));

            }else if(currentTag.equals("baselineProjection")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.baselineProjection));

            }else if(currentTag.equals("budgetAnalysis")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.budgetAnalysis));

            }else if(currentTag.equals("obi")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.obi));

            }else if(currentTag.equals("impactAssessment")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.impactAssessment));

            }else if(currentTag.equals("other")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.other));

            }else if(currentTag.equals("methodology")){
                documentCategoryTags.add(new DocumentCategoryTag(DocumentCategory.methodology));

            }
        }

        Set<TargetAudienceCategoryTag> targetAudienceCategories = new HashSet<>();

        for(String currentTag : postDto.getTargetAudienceCategories()){
            if(currentTag.equals("journalist")){
                targetAudienceCategories.add(new TargetAudienceCategoryTag(TargetAudienceCategory.journalist));

            }else if(currentTag.equals("decisionMaker")){
                targetAudienceCategories.add(new TargetAudienceCategoryTag(TargetAudienceCategory.decisionMaker));

            }else if(currentTag.equals("ngo")){
                targetAudienceCategories.add(new TargetAudienceCategoryTag(TargetAudienceCategory.ngo));

            }else if(currentTag.equals("analyst")){
                targetAudienceCategories.add(new TargetAudienceCategoryTag(TargetAudienceCategory.analyst));

            }else if(currentTag.equals("citizen")){
                targetAudienceCategories.add(new TargetAudienceCategoryTag(TargetAudienceCategory.citizen));
            }
        }

        postDto.getPost().setDocumentCategoryTags(documentCategoryTags);
        postDto.getPost().setTargetAudienceCategoryTags(targetAudienceCategories);

        postRepository.save(postDto.getPost());
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void deleteById(long id){
        this.delete(postRepository.findOne(id));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findByTitle(String title){
        return postRepository.findByTitle(title);
    }

    public Post findById(Long id){ return postRepository.findById(id);}

    public Post update(long id,Post update) {
        Post post = postRepository.findOne(id);
        if( update.getTitle() != null ) {
            post.setTitle(update.getTitle());
        }
        post.setPostedOn(new Timestamp(System.currentTimeMillis()));
        return postRepository.save(post);
    }
}
