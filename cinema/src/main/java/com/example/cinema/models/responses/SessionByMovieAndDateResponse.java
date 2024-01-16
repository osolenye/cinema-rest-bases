package com.example.cinema.models.responses;

import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.entity.Film;
import lombok.Data;

import java.util.List;

@Data
public class SessionByMovieAndDateResponse {
    FilmDto film;
    List<CinemaHelp> cinemaHelps;
}
