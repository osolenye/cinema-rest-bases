package com.example.cinema.rep;

import com.example.cinema.base.BaseRep;
import com.example.cinema.models.entity.Seat;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.enums.SeatStatus;

import java.util.List;

public interface SeatRep extends BaseRep<Seat> {
    List<Seat> findByStatusAndSession(SeatStatus status, Session session);
}
