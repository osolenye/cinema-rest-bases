package com.example.cinema.controllers;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderCreateRequest;
import com.example.cinema.services.OrderService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
@Api(tags = "Order control")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody OrderCreateRequest data, Language language){
        return ResponseEntity.ok(orderService.create(data, language));
    }
}

