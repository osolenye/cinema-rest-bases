package com.example.cinema.models.responses;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    String hallName;
    List<RoomMovieId> roomMovieIds;
}
