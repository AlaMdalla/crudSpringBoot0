package com.example.project.post.DataBase;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource("/application.properties")
public class DatabaseConnectionTest {

    @Value("${mongodb+srv}")
    private String mongoUri;

    @Test
    public void testMongoDBConnection() {
        try {
            MongoClient mongoClient = MongoClients.create(mongoUri);
            assertNotNull(mongoClient);
            mongoClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

