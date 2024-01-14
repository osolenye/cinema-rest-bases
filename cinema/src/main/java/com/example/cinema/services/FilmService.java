package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.entity.Film;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.requests.FilmCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilmService extends BaseService<FilmDto> {
    FilmDto create(MultipartFile logo, FilmCreateRequest request, Language language);

    Page<Film> filter(Integer limit, Integer offset);
}
