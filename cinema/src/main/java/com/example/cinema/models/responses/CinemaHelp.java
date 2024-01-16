package com.example.cinema.models.responses;

import lombok.Data;

import java.util.List;

@Data
public class CinemaHelp {
    String cinemaName;
    List<Room> rooms;
}
