package com.module4.production_ready_feature.production_ready_feature.services;

import com.module4.production_ready_feature.production_ready_feature.dto.PostDTO;

import java.util.List;

public interface PostInterface {
    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO postDTO);

    PostDTO getPostById(Long postId);

    PostDTO updatePost(Long postId, PostDTO inputPost);

}
