package com.example.cinema.controllers;

import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.FilmCreateRequest;
import com.example.cinema.models.responses.Response;
import com.example.cinema.services.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/film")
@AllArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @PostMapping("/create")
    ResponseEntity<?> create(@ModelAttribute FilmCreateRequest filmCreateRequest, Language language) {
            return ResponseEntity.ok(filmService.create(filmCreateRequest.getLogo(), filmCreateRequest, language));
    }


    @GetMapping("/get/all")
    ResponseEntity<?> getAll(@RequestParam Integer limit, @RequestParam Integer offset) {
        return ResponseEntity.ok(filmService.filter(limit, offset));
    }
}
