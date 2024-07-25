package com.example.project.post.Entity;

import com.example.project.post.dto.StripeSubDto;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Document(collection = "StripeSub")

public class StripeSub {
    @MongoId

    private String plan;
    private  int number;

    public StripeSub(String plan, int number) {
        this.plan = plan;
        this.number = number;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public StripeSubDto toDto(){
        return  new  StripeSubDto(this.plan,this.number);
    }
}
