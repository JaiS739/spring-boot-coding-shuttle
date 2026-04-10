package com.module4.production_ready_feature.production_ready_feature.services;

import com.module4.production_ready_feature.production_ready_feature.dto.PostDTO;
import com.module4.production_ready_feature.production_ready_feature.repositories.PostRepository;

import java.util.List;

public class PostService implements PostInterface{

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> getAllPosts(){
        return null;
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost){
        return null;
    }

}
