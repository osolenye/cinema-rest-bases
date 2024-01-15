package com.example.cinema.models.responses;

import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.enums.Language;
import com.example.cinema.services.SeatService;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static com.example.cinema.models.enums.SeatStatus.YOUR;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsResponse {
    double totalPrice;
    List<SeatDto> yourSeats;
    List<SeatDto> freeSeats;
    List<SeatDto> occupiedSeats;
}
