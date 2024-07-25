package com.example.project.post.Services;

import com.example.project.post.Entity.StripeSub;
import com.example.project.post.Repository.StripeSubRepository;
import com.example.project.post.dto.StripeSubDto;
import com.example.project.post.dto.SubscriptionDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubStripeService {
    private final StripeSubRepository stripeSubRepository;
    public  SubStripeService (StripeSubRepository stripeSubRepository){
        this.stripeSubRepository=stripeSubRepository;
    }

    public StripeSubDto create(StripeSubDto dto) {
        StripeSub stripeSub = dto.toEntity();

        stripeSubRepository.save(stripeSub);
        return  stripeSub.toDto();
    }
    public StripeSubDto increment(String id)  {
        Optional<StripeSub> existingStripe = stripeSubRepository.findById(id);
        if (existingStripe.isPresent()) {
            StripeSub subscription = existingStripe.get();
            subscription.setNumber(subscription.getNumber()+1);


            return stripeSubRepository.save(subscription).toDto();
        } else {
            return null;        }}
    public StripeSubDto getByPlan(String id) {
        return stripeSubRepository.getByPlan(id).toDto();
    }


}
