package com.example.project.post.Entity;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PostTest {
    @Test
            public void testCreatepost(){
        Post post =new Post();
        post.setId(1);
        post.setName("aaa");
        post.setDescription("aaa");
        assertNotNull(post);
    }

}
