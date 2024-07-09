package com.example.project.post.Entity;

import com.example.project.post.dto.SubscriptionDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
@Document(collection = "Subscription") // Specify the collection name here
public class Subscription {
    @MongoId
    private String id; // Changed to String as MongoDB uses ObjectId by default

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String plan;

    public void setPlan(String plan) {
        this.plan=plan;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getPlan() {
        return plan;
    }

    public void setStartTime(LocalDateTime startTime) {

     this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {

this.endTime=endTime;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", plan='" + plan + '\'' +
                '}';
    }

    public Subscription(String id, LocalDateTime startTime, LocalDateTime endTime, String plan) {
        this.id = id;

        this.startTime = startTime;
        if(endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.endTime = endTime;
        this.plan = plan;
    }

    public Subscription(LocalDateTime startTime, LocalDateTime endTime, String plan) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.plan = plan;
    }

    public Subscription(){
        System.out.println("constructor");
    }

    /**
     *
     * @return the object of entity Subscription
     */
    public SubscriptionDto toDto(){
        return new SubscriptionDto(this.id,this.startTime,this.endTime,this.plan);
    }
}
