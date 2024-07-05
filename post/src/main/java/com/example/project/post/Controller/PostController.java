package com.example.project.post.Controller;

import com.example.project.post.Services.PostService;
import com.example.project.post.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;
    public  PostController(PostService postService){
        this.postService=postService;
    }
    @PostMapping("/add")
   public PostDto  addPost(@RequestBody PostDto p){
       return this.postService.create(p);
    }

}
