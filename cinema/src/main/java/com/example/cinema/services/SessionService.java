package com.example.cinema.services;

import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.models.responses.SessionByMovieAndDateResponse;

import java.util.Date;
import java.util.List;

public interface SessionService extends BaseService<SessionDto> {
    SessionDto create(SessionCreateRequest request, Language language);
    List<SessionDto> findByFilm(FilmDto filmDto, Language language);
    List<SessionDto> findByDateTime(Date dateTime, Language language);
    List<SessionDto> findByCinema(CinemaDto cinemaDto, Language language);
    List<SessionDto> findByFilmAndDateTime(FilmDto filmDto, Date datetime, Language language);
    List<SessionByMovieAndDateResponse> findByFilmAndDatetimeFormatted(FilmDto filmDto, Date dateTime, Language language);
}