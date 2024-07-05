package com.example.project.post.Entity;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.Flow;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class SubscriptionTest {
    @Test
    public void testCreatesubscription(){
        Subscription sub =new Subscription() ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        sub.setPlan("Vip");
        LocalDateTime startTime = LocalDateTime.parse("2026-05-07 08:00", formatter);

        sub.setStartTime(startTime);
        LocalDateTime endTime = LocalDateTime.parse("2027-05-08 08:00", formatter);

        sub.setEndTime(endTime);
        assertNotNull(sub);
        assertTrue(endTime.isAfter(startTime));

    }
}
