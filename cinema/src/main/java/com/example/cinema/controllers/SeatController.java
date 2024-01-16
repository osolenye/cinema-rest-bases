package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.enums.SeatStatus;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.requests.SeatCreateRequest;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.services.HallService;
import com.example.cinema.services.SeatService;
import com.example.cinema.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat")
@AllArgsConstructor
public class SeatController {
    private final SeatService seatService;
    private final SessionService sessionService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody SeatCreateRequest request, @RequestParam SeatStatus status, Language language) {
        return ResponseEntity.ok(seatService.create(request, status, language));
    }

    @GetMapping("/find/by/{status}")
    ResponseEntity<?> findByStatusAndId(@RequestParam SeatStatus status, @RequestParam Long sessionId, @RequestParam  Language language) {
        return ResponseEntity.ok(seatService.findByStatusAndSession(status, sessionService.findById(sessionId, language), language));
    }
}
