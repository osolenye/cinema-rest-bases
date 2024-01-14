package com.example.cinema.models.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionCreateRequest {

    Long filmId;
    Long hallId;
    Long priceId;
    Date dateTime;
    double discount;
}

