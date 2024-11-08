package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.userDTO;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class userService {
    public String register(userDTO user) {
        // Simulate registration logic
        return "User registered with email: " + user.getEmail();
    }

    public String login(String email, String method) {
        // Simulate login logic
        String token = "TokenGeneratedFor: " + email + "-" + Instant.now().toEpochMilli();
        return token;
    }
}
