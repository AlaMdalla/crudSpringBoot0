package com.example.project.post.Repository;

import com.example.project.post.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository  extends JpaRepository<Subscription,Integer> {

}
