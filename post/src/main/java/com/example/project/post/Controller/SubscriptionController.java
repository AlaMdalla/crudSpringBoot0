package com.example.project.post.Controller;

import com.example.project.post.Services.SubscriptionService;
import com.example.project.post.dto.SubscriptionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    SubscriptionService subscriptionService;
    public SubscriptionController(SubscriptionService subscriptionService)
    {
        this.subscriptionService=subscriptionService;
    }
    @PostMapping("/add")
    public SubscriptionDto addPost(@RequestBody SubscriptionDto s){
        return this.subscriptionService.create(s);
    }
    @PostMapping("/all")
    public List<SubscriptionDto> getAll(){
        return this.subscriptionService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public SubscriptionDto delete(@PathVariable int id){
    return subscriptionService.delte(id);

    }
    @PutMapping("update/{id}")
    public SubscriptionDto updateSubscription(@PathVariable int id, @RequestBody SubscriptionDto dto) {
        return subscriptionService.update(id, dto);
    }




}
