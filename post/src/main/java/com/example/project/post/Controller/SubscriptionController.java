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
    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/add")
    public SubscriptionDto addPost(@RequestBody SubscriptionDto s){
        return this.subscriptionService.create(s);
    }
    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/all")
    public List<SubscriptionDto> getAll(){
        return this.subscriptionService.getAll();
    }
    @CrossOrigin("http://localhost:4200/")
    @DeleteMapping("/delete/{id}")
    public SubscriptionDto delete(@PathVariable String id){
    return subscriptionService.delte(id);

    }
    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/getById/{id}")
    public SubscriptionDto getById(@PathVariable String id){
        return  this.subscriptionService.getById(id);
    }
    @CrossOrigin("http://localhost:4200/")
    @PutMapping("update/{id}")
    public SubscriptionDto updateSubscription(@PathVariable String id, @RequestBody SubscriptionDto dto) {
        return subscriptionService.update(id, dto);
    }
    @CrossOrigin("http://localhost:4200/")
    @GetMapping(value = {"/getByPlan/{plan}","/getByPlan/"})
    public List<SubscriptionDto> getByPlan(@PathVariable (required = false) String plan){
        if(plan==null ||plan.isEmpty())
            return this.getAll();
        return  this.subscriptionService.getByPlan(plan);
    }



}
