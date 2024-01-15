package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.services.CinemaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cinema")
@AllArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;

    @PostMapping("/create")
    ResponseEntity<?> create(@ModelAttribute CinemaCreateRequest request, Language language) {
        return ResponseEntity.ok(cinemaService.create(request.getLogo(), request, language));
    }


    @GetMapping("/find/by/{name}")
    ResponseEntity<?> findByName(@RequestParam String name, @RequestParam Language language) {
        return ResponseEntity.ok(cinemaService.findByName(name, language));
    }

    @GetMapping("/find/all")
    ResponseEntity<?> findAll(@RequestParam Language language) {
        return ResponseEntity.ok(cinemaService.findAll(language));
    }
}

