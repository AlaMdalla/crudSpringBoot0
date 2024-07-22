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
    private  String backgroundColor;
    private double price;
    //lena nzidou options
    private boolean feature1;
    private int numberOfMonthes;

    public int getNumberOfMonthes() {
        return numberOfMonthes;
    }

    public void setNumberOfMonthes(int numberOfMonthes) {
        this.numberOfMonthes = numberOfMonthes;
    }

    public boolean isFeature1() {
        return feature1;
    }

    public void setFeature1(boolean feature1) {
        this.feature1 = feature1;
    }

    public boolean isFeature2() {
        return feature2;
    }

    public void setFeature2(boolean feature2) {
        this.feature2 = feature2;
    }

    public boolean isFeature3() {
        return feature3;
    }

    public void setFeature3(boolean feature3) {
        this.feature3 = feature3;
    }

    public boolean isFeature4() {
        return feature4;
    }

    public void setFeature4(boolean feature4) {
        this.feature4 = feature4;
    }

    private boolean feature2;
    private boolean feature3;
    private boolean feature4;



    public Subscription(String id, LocalDateTime startTime, LocalDateTime endTime, String plan, String backgroundColor, double price, boolean feature1, boolean feature2, boolean feature3, boolean feature4 ,int numberOfMonthes) {
        this.id = id;

        this.startTime = startTime;
        if(endTime.isBefore(startTime))
            throw new IllegalArgumentException("End time must be after start time.");
        this.endTime = endTime;
        this.plan = plan;
        this.backgroundColor=backgroundColor;
        this.price =price;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.feature4 = feature4;
        this.numberOfMonthes=numberOfMonthes;
    }



    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
    public SubscriptionDto toDto() {
        System.out.println(this.plan);
        String backgroundColor;
        switch (this.plan) {
            case "annuel":
                backgroundColor = "linear-gradient(to bottom right, #f2f2f2 0%, #e0e0e0 80%, #d0d0d0 100%)"; // Light gray with subtle bottom right corner (Changed from light gray to slightly darker)
                break;
            case "mensuel":
                backgroundColor = "linear-gradient(135deg, #ffafbd 0%, #ffc3a0 100%)        "; // Dark charcoal to even darker charcoal
                break;
            case "Business":
                backgroundColor = "linear-gradient(to bottom right, #d6ceff 0%, #93a1a4 100%)"; // Amethyst gradient - Mystical Amethyst (Changed from light beige to soft green to amethyst)
                break;
            case "Business Elite":
                backgroundColor = "linear-gradient(135deg, #c3cfe2 0%, #c3cfe2 100%)"; // Light rose gold to darker rose gold
                break;
            default:
                backgroundColor = "linear-gradient(to bottom right, #f5f5f5 0%, #e0e0e0 80%, #d0d0d0 100%)"; // Default light gray with subtle bottom right corner
                break;
        }

        System.out.println(backgroundColor);
        System.out.println(this.getNumberOfMonthes());
        return new SubscriptionDto(this.id, this.startTime, this.endTime, this.plan, backgroundColor ,this.price, this.feature1, this.feature2, this.feature3, this.feature4,this.numberOfMonthes);
    }



}
