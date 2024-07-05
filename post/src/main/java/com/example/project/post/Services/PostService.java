package com.example.project.post.Services;

import com.example.project.Service.Crud;
import com.example.project.post.Entity.Post;
import com.example.project.post.Repository.PostRepository;
import com.example.project.post.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements Crud<PostDto,Integer> {
   private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto create(PostDto dto) {
Post p=dto.toEntity();
        this.postRepository.save(p);
return p.toDto();
    }


    @Override
    public List<PostDto> getAll() {
        return null;
    }

    @Override
    public PostDto getById(Integer id) {
        return null;
    }

    @Override
    public PostDto update(Integer id, PostDto dto) {
        return null;
    }


    @Override
    public PostDto delte(Integer id ) {
        return null;
    }
}
