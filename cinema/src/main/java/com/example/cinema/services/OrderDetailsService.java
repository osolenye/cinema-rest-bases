package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.OrderDetailsDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderDetailsCreateRequest;
import org.springframework.stereotype.Service;

public interface OrderDetailsService extends BaseService<OrderDetailsDto> {
    OrderDetailsDto create(OrderDetailsCreateRequest request, Language lang);
}