package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.services.CinemaService;
import com.example.cinema.services.FilmService;
import com.example.cinema.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/session")
@AllArgsConstructor
public class SessionController {
    private final SessionService sessionService;
    private final FilmService filmService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody SessionCreateRequest request, Language language) {
        return ResponseEntity.ok(sessionService.create(request, language));
    }

    @GetMapping("/find/by/film/{id}")
    ResponseEntity<?> findByFilm(@RequestParam Long filmId, @RequestParam Language language) {
        return ResponseEntity.ok(sessionService.findByFilm(filmService.findById(filmId, language), language));
    }

    @GetMapping("/find/by/{dateTime}")
    ResponseEntity<?> findByDateTime(@RequestParam String dateTime, @RequestParam Language language) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            Date date = dateFormat.parse(dateTime);
            return ResponseEntity.ok(sessionService.findByDateTime(date, language));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
