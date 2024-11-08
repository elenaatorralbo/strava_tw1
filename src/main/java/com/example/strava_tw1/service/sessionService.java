package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.sessionDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class sessionService {
    private final List<sessionDTO> sessions = new ArrayList<>(); // Lista en memoria para almacenar sesiones

    public String createSession(sessionDTO session) {
        sessions.add(session); // Agregar la sesión a la lista
        return "Session created: " + session.getTitle();
    }

    public List<sessionDTO> getSessions() {
        return sessions; // Retorna todas las sesiones almacenadas en memoria
    }
}
