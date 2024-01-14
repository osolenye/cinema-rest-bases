package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.responses.Response;

public interface HallService extends BaseService<HallDto> {
    HallDto create(HallCreateRequest request, Language lang);
}