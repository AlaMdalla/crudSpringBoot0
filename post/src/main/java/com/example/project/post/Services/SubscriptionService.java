package com.example.project.post.Services;

import com.example.project.Service.Crud;
import com.example.project.post.Entity.Subscription;
import com.example.project.post.Repository.SubscriptionRepository;
import com.example.project.post.dto.SubscriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements Crud<SubscriptionDto,Integer> {

     private final  SubscriptionRepository subscriptionRepository;
     @Autowired
     public SubscriptionService(SubscriptionRepository subscriptionRepository){
         this.subscriptionRepository=subscriptionRepository;
     }
    @Override
    public SubscriptionDto create(SubscriptionDto dto) {
Subscription subscription = dto.toEntity();

   subscriptionRepository.save(subscription);
   return  subscription.toDto();
     }

    @Override
    public List<SubscriptionDto> getAll() {
        return this.subscriptionRepository.findAll().stream().map(a->a.toDto()).toList();
    }

    @Override
    public SubscriptionDto getById(Integer id) {
        return subscriptionRepository.getById(id).toDto();
    }

    @Override
    public SubscriptionDto update(Integer id, SubscriptionDto dto)  {
        Optional<Subscription> existingSubscription = subscriptionRepository.findById(id);
        if (existingSubscription.isPresent()) {
            Subscription subscription = existingSubscription.get();
            subscription.setStartTime(dto.getStartTime());
            subscription.setEndTime(dto.getEndTime());
            subscription.setPlan(dto.getPlan());
            return subscriptionRepository.save(subscription).toDto();
        } else {
return null;        }}

    @Override
    public SubscriptionDto delte(Integer id) {

        SubscriptionDto subscriptionDto= this.getById(id);
        Subscription subscription =subscriptionDto.toEntity();

         this.subscriptionRepository.delete(subscription);
         return subscription.toDto();
    }
}
