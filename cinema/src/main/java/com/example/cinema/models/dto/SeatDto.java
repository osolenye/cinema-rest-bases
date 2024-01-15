package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import com.example.cinema.models.enums.SeatStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatDto extends BaseDto {
    Long id;
    int seat;
    SeatStatus status;
    SessionDto session;
}
