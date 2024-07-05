package com.example.project.post.dto;

import com.example.project.post.Entity.SubscriptionTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubscriptionDtoTest {
    @Test
    public void createSubscription(){
        SubscriptionDto subDto = new SubscriptionDto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        subDto.setPlan(subDto.getPlan());
        LocalDateTime startTime = LocalDateTime.parse("2024-05-07 08:00", formatter);

        subDto.setStartTime(startTime);
        LocalDateTime endTime = LocalDateTime.parse("2025-05-08 08:00", formatter);

        subDto.setEndTime(endTime);
        assertNotNull(subDto);
        assertTrue(endTime.isAfter(startTime));
    }
}
