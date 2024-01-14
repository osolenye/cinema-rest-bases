package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import com.example.cinema.models.enums.Ticket;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDto extends BaseDto {
    Long id;
    double price;
    Ticket type;
}