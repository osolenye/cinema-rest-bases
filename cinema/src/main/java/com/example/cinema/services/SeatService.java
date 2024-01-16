package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.enums.SeatStatus;
import com.example.cinema.models.requests.SeatCreateRequest;

import java.util.List;

public interface SeatService extends BaseService<SeatDto> {
    SeatDto create(SeatCreateRequest request, SeatStatus status, Language language);
    List<SeatDto> findByStatusAndSession(SeatStatus status, SessionDto session, Language language);
}
