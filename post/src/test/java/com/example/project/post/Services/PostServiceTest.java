package com.example.project.post.Services;

import com.example.project.post.Entity.Post;
import com.example.project.post.Repository.PostRepository;
import com.example.project.post.dto.PostDto;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class PostServiceTest  {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }
@Test
void testCreatePost() {
        // Given
    Post postToSve = new Post(1, "a", "John Doe");
    PostDto postDto = postToSve.toDto();
    System.out.println("test"+postDto);

   PostDto createdPost=  postService.create(postDto);
    assertNotNull(createdPost);
    assertEquals(postToSve.getId(),createdPost.id());
    assertEquals(postToSve.getName(),createdPost.name());
   verify(postRepository, times(1)).save(any(Post.class));





}



}
