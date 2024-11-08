package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.sessionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class sessionService {
    private final List<sessionDTO> sessions = new ArrayList<>(); // Lista en memoria para almacenar sesiones

    public String createSession(sessionDTO session, String token) {
        session.setToken(token); // Asocia el token a la sesión
        sessions.add(session); // Agregar la sesión a la lista
        return "Session created: " + session.getTitle();
    }

    public List<sessionDTO> getSessions(String token) {
        // Filtrar sesiones por token y ordenar por fecha y hora descendente, limitando a las últimas 5
        return sessions.stream()
                .filter(session -> session.getToken().equals(token))
                .sorted(Comparator.comparing(sessionDTO::getStartDate)
                        .thenComparing(sessionDTO::getStartTime)
                        .reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
