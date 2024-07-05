package com.example.project.post.Repository;

import com.example.project.post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Integer > {
}
