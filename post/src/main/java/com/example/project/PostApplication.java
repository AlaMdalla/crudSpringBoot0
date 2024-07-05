package com.example.project;

import com.example.project.post.Entity.Subscription;
import com.example.project.post.Services.PostService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@SpringBootApplication
public class PostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		LocalDateTime invalidStartTime = LocalDateTime.parse("2025-05-08 08:00", formatter);

			LocalDateTime invalidEndTime = LocalDateTime.parse("2024-05-07 08:00", formatter);

		Subscription invalidSub = new Subscription(1,invalidStartTime,invalidEndTime,"aa");

		System.out.println("test:");
		System.out.println(invalidSub);
	}

}
