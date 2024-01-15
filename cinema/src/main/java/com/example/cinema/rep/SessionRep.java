package com.example.cinema.rep;

import com.example.cinema.base.BaseRep;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.entity.Film;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.enums.Language;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SessionRep extends BaseRep<Session> {
    List<Session> findByFilm(Film film);
    List<Session> findByDateTime(Date dateTime);
    List<Session> findByCinema(Cinema cinema);
}
