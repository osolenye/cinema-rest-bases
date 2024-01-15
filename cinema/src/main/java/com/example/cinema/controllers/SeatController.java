package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.requests.SeatCreateRequest;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.services.HallService;
import com.example.cinema.services.SeatService;
import com.example.cinema.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seat")
@AllArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody SeatCreateRequest request, Language language) {
        return ResponseEntity.ok(seatService.create(request, language));
    }
}
