package com.example.cinema.models.requests;

import com.example.cinema.models.enums.Ticket;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceCreateRequest {
    double price;
    Ticket type;
}
