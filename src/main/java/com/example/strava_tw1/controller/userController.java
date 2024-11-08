package com.example.strava_tw1.controller;

import com.example.strava_tw1.dto.userDTO;
import com.example.strava_tw1.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import org.springframework.stereotype.Service;

@RestController
@RequestMapping("/api/user")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/register")
    public String register(@RequestBody userDTO user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String method) {
        return userService.login(email, method);
    }
}
