package com.example.cinema.rep;

import com.example.cinema.base.BaseRep;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.entity.Cinema;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRep extends BaseRep<Cinema> {
//    List<CinemaDto> findByName(String name);
    boolean existsByName(String name);

}
