package com.example.cinema.controllers;

import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.services.CinemaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cinema")
@AllArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;

    @PostMapping("/create")
    ResponseEntity<?>create(@ModelAttribute CinemaCreateRequest request) {
        try {
            return ResponseEntity.ok(cinemaService.create(request.getLogo(), request));
        } catch (Exception e) {
            return new ResponseEntity<>("couldn't create the object", HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
