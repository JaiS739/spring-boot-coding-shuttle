package com.module4.production_ready_feature.production_ready_feature.services;

import com.module4.production_ready_feature.production_ready_feature.dto.PostDTO;
import com.module4.production_ready_feature.production_ready_feature.entities.PostEntity;
import com.module4.production_ready_feature.production_ready_feature.exceptions.ResourceNotFoundException;
import com.module4.production_ready_feature.production_ready_feature.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class PostService implements PostInterface{

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    //instead of constructor injection you can use @RequiredArgsConstructor
    public PostService(PostRepository postRepository, ModelMapper modelMapper){
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDTO> getAllPosts(){
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .toList();
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost){
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        PostEntity savedEntity = postRepository.save(postEntity);
        return modelMapper.map(savedEntity, PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId){
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with Id " + postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

}
