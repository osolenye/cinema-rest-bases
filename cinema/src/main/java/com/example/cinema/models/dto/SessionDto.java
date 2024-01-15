package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionDto extends BaseDto {
    Long id;
    FilmDto film;
    HallDto hall;
    Date dateTime;
    PriceDto price;
    double discount;
    CinemaDto cinema;
}
