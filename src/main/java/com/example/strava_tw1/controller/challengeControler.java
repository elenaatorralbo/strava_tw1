package com.example.strava_tw1.controller;

import com.example.strava_tw1.dto.challengeDTO;
import com.example.strava_tw1.service.challengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private challengeService challengeService;

    @PostMapping("/create")
    public String createChallenge(@RequestBody challengeDTO challenge) {
        return challengeService.createChallenge(challenge);
    }

    @GetMapping("/active")
    public List<challengeDTO> getActiveChallenges() {
        return challengeService.getActiveChallenges();
    }
}
