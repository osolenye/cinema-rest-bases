package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.responses.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface CinemaService extends BaseService<CinemaDto> {
    CinemaDto create(MultipartFile logo, CinemaCreateRequest request, Language language);

//    List<CinemaDto> findByName(String name);
}
