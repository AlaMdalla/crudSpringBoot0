package com.example.project.post.Controller;

import com.example.project.post.Services.SubStripeService;
import com.example.project.post.Services.SubscriptionService;
import com.example.project.post.dto.StripeSubDto;
import com.example.project.post.dto.SubscriptionDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/substripe")
public class stripeSubController {
    SubStripeService subStripeService;
    public stripeSubController(SubStripeService subscriptionService)
    {
        this.subStripeService=subscriptionService;
    }
    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/add")
    public StripeSubDto add(@RequestBody StripeSubDto s){
        return this.subStripeService.create(s);
    }
    @CrossOrigin("http://localhost:4200/")
    @GetMapping("increment/{id}")
        public int incrementstripeSub(@PathVariable String id) {
        return subStripeService.increment(id).getNumber();
    }
    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/getById/{id}")
    public int getById(@PathVariable String id){
        return  this.subStripeService.getByPlan(id).getNumber();
    }
}
