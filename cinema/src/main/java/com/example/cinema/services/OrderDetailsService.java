package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.OrderDetailsDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderDetailsCreateRequest;
import com.example.cinema.models.responses.OrderDetailsResponse;
import org.springframework.stereotype.Service;

public interface OrderDetailsService extends BaseService<OrderDetailsDto> {
    OrderDetailsResponse create(OrderDetailsCreateRequest request, Language lang);
}