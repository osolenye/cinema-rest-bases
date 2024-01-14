package com.example.cinema.rep;

import com.example.cinema.base.BaseRep;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.entity.Hall;
import feign.Param;
import org.springframework.data.jpa.repository.Query;

public interface HallRep extends BaseRep<Hall> {
    boolean existsByName(String name);
    @Query("select c from Cinema c where c.id = :cinemaId")
    Cinema findByIdCinema(@Param("cinemaId") Long cinemaId);
}
