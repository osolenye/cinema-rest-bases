package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.enums.Ticket;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.requests.PriceCreateRequest;
import com.example.cinema.services.HallService;
import com.example.cinema.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/price")
@AllArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestParam double price, Ticket type, Language language) {
        PriceCreateRequest request = new PriceCreateRequest();
        request.setPrice(price);
        request.setType(type);
        return ResponseEntity.ok(priceService.create(request, language));
    }
}