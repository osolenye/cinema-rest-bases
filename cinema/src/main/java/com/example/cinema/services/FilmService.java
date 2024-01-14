package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.requests.FilmCreateRequest;
import org.springframework.web.multipart.MultipartFile;

public interface FilmService extends BaseService<FilmDto> {
    FilmDto create(MultipartFile logo, FilmCreateRequest request, Language language);

}
