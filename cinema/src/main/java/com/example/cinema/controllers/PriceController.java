package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.requests.PriceCreateRequest;
import com.example.cinema.services.HallService;
import com.example.cinema.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
@AllArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody PriceCreateRequest request, Language language) {
        return ResponseEntity.ok(priceService.create(request, language));
    }
}