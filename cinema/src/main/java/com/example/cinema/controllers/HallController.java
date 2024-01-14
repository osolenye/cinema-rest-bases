package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.responses.Response;
import com.example.cinema.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hall")
@AllArgsConstructor
public class HallController {
    private final HallService hallService;

    @PostMapping("/create")
    ResponseEntity<?> create(HallCreateRequest request, Language language) {
        return ResponseEntity.ok(hallService.create(request, language));
    }
}
