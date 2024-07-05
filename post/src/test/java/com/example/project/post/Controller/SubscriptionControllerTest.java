package com.example.project.post.Controller;
import com.example.project.post.Entity.Subscription;
import com.example.project.post.dto.SubscriptionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SubscriptionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAdd() throws Exception {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        String plan = "Example plan";
        SubscriptionDto sub = new SubscriptionDto(startTime,endTime,plan);

        mockMvc.perform(post("http://localhost:8082/api/subscription/add")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(sub)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.plan").value("Example plan"))
                .andExpect(jsonPath("$.endTime").exists());


    }
}
