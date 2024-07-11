package com.example.project.post.dto;

import com.example.project.post.Entity.Subscription;

import java.time.LocalDateTime;

public class SubscriptionDto {
    public SubscriptionDto(String id, LocalDateTime startTime, LocalDateTime endTime, String plan, String backgroundColor) {
        if(endTime!=null&&endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.plan = plan;
        this.backgroundColor=backgroundColor;
    }

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
    private  String backgroundColor;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public SubscriptionDto(String id, LocalDateTime startTime, LocalDateTime endTime, String plan) {

        if(endTime!=null&&endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.plan = plan;
        switch (plan){
            case "Light":
                this.backgroundColor= "#ffffff";
            case "Core":
                this.backgroundColor= "#800080";
            case "Business":
                this.backgroundColor= "#ffd700";
            case "Business Elite":
                this.backgroundColor=  "#ff0000";
            default:
                this.backgroundColor= "#ffffff";
        }
    }

    public SubscriptionDto() {
    }

    public SubscriptionDto(LocalDateTime startTime, LocalDateTime endTime, String plan) {

        if(endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.startTime = startTime;
        this.endTime = endTime;
        this.plan = plan;
        switch (plan){
            case "Light":
                this.backgroundColor= "#ffffff";
            case "Core":
                this.backgroundColor= "#800080";
            case "Business":
                this.backgroundColor= "#ffd700";
            case "Business Elite":
                this.backgroundColor=  "#ff0000";
            default:
                this.backgroundColor= "#ffffff";
        }
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
        switch (plan){
            case "Light":
                this.backgroundColor= "#ffffff";
            case "Core":
                this.backgroundColor= "#800080";
            case "Business":
                this.backgroundColor= "#ffd700";
            case "Business Elite":
                this.backgroundColor=  "#ff0000";
            default:
                this.backgroundColor= "#ffffff";
        }
        return new Subscription(this.id,this.startTime,this.endTime,this.plan,this.backgroundColor);

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
