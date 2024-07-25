package com.example.project.post.Repository;

import com.example.project.post.Entity.StripeSub;
import com.example.project.post.Entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StripeSubRepository   extends MongoRepository<StripeSub,String> {
    StripeSub getByPlan(String plan);
}
