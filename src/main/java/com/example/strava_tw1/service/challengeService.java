package com.example.strava_tw1.service;

import com.example.strava_tw1.dto.challengeDTO;
import com.example.strava_tw1.dto.sessionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class challengeService {
    private final List<challengeDTO> challenges = new ArrayList<>();
    private final Map<String, List<challengeDTO>> userAcceptedChallenges = new HashMap<>(); // Almacena los challenges aceptados por usuario (token)

    // Crear un nuevo challenge y almacenarlo
    public String createChallenge(challengeDTO challenge) {
        challenges.add(challenge);
        return "Challenge created: " + challenge.getName();
    }

    // Listar los últimos 5 challenges activos por fecha
    public List<challengeDTO> getActiveChallenges(String token, String sport, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return challenges.stream()
                .filter(challenge -> {
                    // Filtrar por fecha y deporte si se proporciona
                    LocalDate start = LocalDate.parse(challenge.getStartDate(), formatter);
                    LocalDate end = LocalDate.parse(challenge.getEndDate(), formatter);
                    boolean dateInRange = (startDate == null || LocalDate.parse(startDate, formatter).isBefore(end)) &&
                            (endDate == null || LocalDate.parse(endDate, formatter).isAfter(start));
                    boolean sportMatch = sport == null || challenge.getSport().equalsIgnoreCase(sport);
                    return dateInRange && sportMatch;
                })
                .sorted(Comparator.comparing(challengeDTO::getEndDate).reversed()) // Ordenar por fecha de finalización descendente
                .limit(5) // Limitar a los últimos 5 challenges
                .collect(Collectors.toList());
    }

    // Aceptar un challenge y asociarlo al token del usuario
    public String acceptChallenge(String token, challengeDTO challenge) {
        userAcceptedChallenges.computeIfAbsent(token, k -> new ArrayList<>()).add(challenge);
        return "Challenge accepted: " + challenge.getName();
    }

    // Consultar el estado de los challenges aceptados por el usuario
    public List<String> getChallengeStatus(String token, List<sessionDTO> sessions) {
        List<String> progressList = new ArrayList<>();

        if (!userAcceptedChallenges.containsKey(token)) {
            return progressList; // No hay challenges aceptados por el usuario
        }

        for (challengeDTO challenge : userAcceptedChallenges.get(token)) {
            int goalValue = challenge.getGoalValue();
            String goalType = challenge.getGoalType();
            String sport = challenge.getSport();

            // Filtrar sesiones del mismo deporte dentro del periodo del challenge
            int totalValue = sessions.stream()
                    .filter(session -> session.getSport().equalsIgnoreCase(sport) &&
                            session.getStartDate().compareTo(challenge.getStartDate()) >= 0 &&
                            session.getStartDate().compareTo(challenge.getEndDate()) <= 0)
                    .mapToInt(session -> goalType.equals("distance") ? (int) session.getDistance() : Integer.parseInt(session.getDuration()))
                    .sum();

            int progressPercentage = (totalValue * 100) / goalValue;
            progressList.add("Challenge: " + challenge.getName() + " - Progress: " + progressPercentage + "%");
        }

        return progressList;
    }
}
