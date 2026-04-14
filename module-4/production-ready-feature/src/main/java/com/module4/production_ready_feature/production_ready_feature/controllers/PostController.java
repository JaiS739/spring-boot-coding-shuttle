package com.module4.production_ready_feature.production_ready_feature.controllers;

import com.module4.production_ready_feature.production_ready_feature.dto.PostDTO;
import com.module4.production_ready_feature.production_ready_feature.services.PostInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="/posts")
public class PostController {
    public final PostInterface postInterface;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postInterface.getAllPosts();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost){
        return postInterface.createNewPost(inputPost);
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postInterface.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePost(@PathVariable Long postId,@RequestBody PostDTO inputPost){
        return postInterface.updatePost(postId, inputPost);
    }
}
