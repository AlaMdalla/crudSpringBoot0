package com.example.project.post.dto;

import com.example.project.post.Entity.StripeSub;

public class StripeSubDto {
    private String plan;
    private  int number;

    public StripeSubDto(String plan, int number) {
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
   public StripeSub toEntity(){
        return new StripeSub(this.plan,this.number);
    }
}
