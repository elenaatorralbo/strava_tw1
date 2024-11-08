package com.example.strava_tw1.controller;

import com.example.strava_tw1.dto.userDTO;
import com.example.strava_tw1.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/register")
    public String register(@RequestBody userDTO user, @RequestParam String method) {
        if (method.equals("google")) {
            return userService.registerWithGoogle(user);
        } else if (method.equals("facebook")) {
            return userService.registerWithFacebook(user);
        } else {
            return "Error: Invalid registration method. Please use 'google' or 'facebook'.";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String method) {
        return userService.login(email, method);
    }
}
