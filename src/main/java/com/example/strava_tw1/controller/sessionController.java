package com.example.strava_tw1.controller;

import com.example.strava_tw1.dto.sessionDTO;
import com.example.strava_tw1.service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private sessionService sessionService;

    @PostMapping("/create")
    public String createSession(@RequestBody sessionDTO session) {
        return sessionService.createSession(session);
    }

    @GetMapping("/get")
    public List<sessionDTO> getSessions() {
        return sessionService.getSessions();
    }
}
