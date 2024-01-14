package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class HallDto extends BaseDto {
    Long id;
    String name;
    CinemaDto cinema;
    int seatRows;
    int seatCount;
}
