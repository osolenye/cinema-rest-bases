package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.SeatCreateRequest;

public interface SeatService extends BaseService<SeatDto> {
    SeatDto create(SeatCreateRequest request, Language language);
}
