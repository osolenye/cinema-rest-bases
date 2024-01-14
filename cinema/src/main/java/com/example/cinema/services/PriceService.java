package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.dto.PriceDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.models.requests.PriceCreateRequest;

public interface PriceService extends BaseService<PriceDto> {
    PriceDto create(PriceCreateRequest request, Language lang);

}
