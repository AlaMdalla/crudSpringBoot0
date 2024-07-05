package com.example.project.post.Services;

import com.example.project.post.Entity.Post;
import com.example.project.post.Entity.Subscription;
import com.example.project.post.Repository.PostRepository;
import com.example.project.post.Repository.SubscriptionRepository;
import com.example.project.post.dto.PostDto;
import com.example.project.post.dto.SubscriptionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SubscribtionServiceTEST {
    @Mock
    private SubscriptionRepository subscriptionRepository;
    @InjectMocks
    private SubscriptionService subscriptionServive;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void createServiceTest() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        String plan = "Example plan";

        when(subscriptionRepository.save(any())).thenReturn(new Subscription());
        Subscription sub = new Subscription(startTime,endTime,plan);
        SubscriptionDto subdo=sub.toDto();
       SubscriptionDto result =subscriptionServive.create(subdo);
    assertNotNull(result);
    assertEquals(startTime, result.getStartTime());
       assertEquals(endTime, result.getEndTime());
     assertEquals(plan, result.getPlan());

       verify(subscriptionRepository, times(1)).save(any());
    }
    @Test
    public void  getAll(){
        List<SubscriptionDto> allSubs = subscriptionServive.getAll();
        assertNotNull(allSubs);
        System.out.println(allSubs);
        assertEquals(2,allSubs.size());
    }
    @Test
    void testGetAllSubscriptions() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);

        Subscription sub1 = new Subscription(startTime, endTime, "Plan A");
        Subscription sub2 = new Subscription(startTime, endTime, "Plan B");

        List<Subscription> subscriptions = Arrays.asList(sub1, sub2);

        when(subscriptionRepository.findAll()).thenReturn(subscriptions);

        List<SubscriptionDto> result = subscriptionServive.getAll();
        System.out.println(result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

}
