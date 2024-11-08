package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.sessionDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class sessionService {
    public String createSession(sessionDTO session) {
        // Simulate session creation logic
        return "Session created: " + session.getTitle();
    }

    public List<sessionDTO> getSessions() {
        // Simulate retrieving sessions (returning an empty list)
        return new ArrayList<>();
    }
}
