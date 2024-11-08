package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.challengeDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    public String createChallenge(challengeDTO challenge) {
        // Simulate challenge creation logic
        return "Challenge created: " + challenge.getName();
    }

    public List<challengeDTO> getActiveChallenges() {
        // Simulate retrieving active challenges (returning an empty list)
        return new ArrayList<>();
    }
}
