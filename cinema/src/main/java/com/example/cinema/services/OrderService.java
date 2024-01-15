package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.OrderDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderCreateRequest;

public interface OrderService extends BaseService<OrderDto> {
    OrderDto create (OrderCreateRequest request, Language language);
}
