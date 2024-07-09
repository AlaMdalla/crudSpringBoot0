package com.example.project.post.dto;

import com.example.project.post.Entity.Subscription;

import java.time.LocalDateTime;

public class SubscriptionDto {
    public String getId() {
        return id;
    }

        public void setId(String id) {
        this.id = id;
    }

    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String plan;

    public SubscriptionDto(String id, LocalDateTime startTime, LocalDateTime endTime, String plan) {

        if(endTime!=null&&endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.plan = plan;
    }

    public SubscriptionDto() {
    }

    public SubscriptionDto(LocalDateTime startTime, LocalDateTime endTime, String plan) {

        if(endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.startTime = startTime;
        this.endTime = endTime;
        this.plan = plan;
    }

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

            this.endTime = endTime;

    }
    public Subscription toEntity(){

        return new Subscription(this.id,this.startTime,this.endTime,this.plan);

    }

    @Override
    public String toString() {
        return "SubscriptionDto{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", plan='" + plan + '\'' +
                '}';
    }
}
