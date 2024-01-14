package com.example.cinema.models.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HallCreateRequest {

    String name;
    Long cinemaId;
    int seatCount;
    int seatRows;
}