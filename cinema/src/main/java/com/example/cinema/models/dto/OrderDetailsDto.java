package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsDto extends BaseDto {
    Long id;
    OrderDto order;
    SessionDto session;
    SeatDto seats;
    double price;
    int num;
}