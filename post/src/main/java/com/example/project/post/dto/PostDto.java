package com.example.project.post.dto;

import com.example.project.post.Entity.Post;

public record PostDto(Integer id, String name, String description) {
    /**
     * change object to entity
     * @param name the name of the object wich is the same of the entity
     */
    public PostDto(String name, String description) {
        this(0, name, description);
    }

    public Post toEntity(){

        Post post=new Post();
        post.setName(this.name);
        post.setDescription(this.description);
        return post;
    }
}
