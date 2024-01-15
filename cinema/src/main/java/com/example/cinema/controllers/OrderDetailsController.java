package com.example.cinema.controllers;


import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderDetailsCreateRequest;
import com.example.cinema.services.OrderDetailsService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order/details")
@Api(tags = "Order Details Control")
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @PostMapping("/create")
    ResponseEntity<?> create (@RequestBody OrderDetailsCreateRequest request, Language language){
        return ResponseEntity.ok(orderDetailsService.create(request, language));
    }
}