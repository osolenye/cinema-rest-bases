package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.requests.CinemaCreateRequest;
import org.springframework.web.multipart.MultipartFile;


public interface CinemaService extends BaseService<CinemaDto> {
    CinemaDto create(MultipartFile logo, CinemaCreateRequest request);
}
