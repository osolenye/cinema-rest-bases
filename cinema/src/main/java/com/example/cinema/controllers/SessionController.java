package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.services.CinemaService;
import com.example.cinema.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/session")
@AllArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody  SessionCreateRequest request, Language language) {
            return ResponseEntity.ok(sessionService.create( request, language));
    }
}
