package com.example.project.post.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostDtoTest {
    @Test
    public void createPostDto(){
        PostDto postDto =new PostDto(1,"ala","test");
        assertNotNull(postDto);

    }

    @Test
    void toEntity() {
    }

    @Test
    void id() {
    }

    @Test
    void name() {
    }

    @Test
    void description() {
    }
}
