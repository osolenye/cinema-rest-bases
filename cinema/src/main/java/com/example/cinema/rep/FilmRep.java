package com.example.cinema.rep;

import com.example.cinema.base.BaseRep;
import com.example.cinema.models.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRep extends BaseRep<Film> {
    Page<Film> findAll(Pageable pageable);
}
