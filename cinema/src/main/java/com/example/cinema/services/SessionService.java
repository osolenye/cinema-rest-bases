package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.SessionCreateRequest;

public interface SessionService extends BaseService<SessionDto> {
    SessionDto create(SessionCreateRequest request, Language language);
}