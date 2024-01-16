package com.example.cinema.models.responses;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RoomMovieId {
    double standartPrice;
    double childPrice;
    Date dateTime;
}
