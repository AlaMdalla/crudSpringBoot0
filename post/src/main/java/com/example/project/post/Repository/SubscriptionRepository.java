package com.example.project.post.Repository;

import com.example.project.post.Entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository  extends MongoRepository<Subscription,String> {

    Subscription getById(String id);
}
