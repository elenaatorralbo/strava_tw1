package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.userDTO;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class userService {

    public String registerWithGoogle(userDTO user) {
        // Lógica de registro para Google
        return "User registered with Google: " + user.getEmail();
    }

    public String registerWithFacebook(userDTO user) {
        // Lógica de registro para Facebook
        return "User registered with Facebook: " + user.getEmail();
    }

    public String login(String email, String method) {
        // Verificar método de autenticación
        if (!method.equals("google") && !method.equals("facebook")) {
            return "Error: Invalid authentication method. Please use 'google' or 'facebook'.";
        }

        // Simulación de generación de token
        String token = "TokenGeneratedFor: " + email + "-" + Instant.now().toEpochMilli();
        return token;
    }
}
