package com.example.strava_tw1.controller;

import com.example.strava_tw1.dto.challengeDTO;
import com.example.strava_tw1.dto.sessionDTO;
import com.example.strava_tw1.service.challengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
public class challengeController {

    @Autowired
    private challengeService challengeService;

    @PostMapping("/create")
    public String createChallenge(@RequestBody challengeDTO challenge) {
        return challengeService.createChallenge(challenge);
    }

    @GetMapping("/active")
    public List<challengeDTO> getActiveChallenges(
            @RequestParam String token,
            @RequestParam(required = false) String sport,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        return challengeService.getActiveChallenges(token, sport, startDate, endDate);
    }

    @PostMapping("/accept")
    public String acceptChallenge(@RequestParam String token, @RequestBody challengeDTO challenge) {
        return challengeService.acceptChallenge(token, challenge);
    }

    @GetMapping("/status")
    public List<String> getChallengeStatus(@RequestParam String token, @RequestBody List<sessionDTO> sessions) {
        return challengeService.getChallengeStatus(token, sessions);
    }
}
