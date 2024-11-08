package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.userDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String register(UserDTO user) {
        // Simulate registration logic
        return "User registered with email: " + user.getEmail();
    }

    public String login(String email, String method) {
        // Simulate login logic
        return "TokenGeneratedFor:" + email;
    }
}
