package com.example.cinema.models.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsCreateRequest {

    Long orderId;
    Long sessionId;
    Long seatsId;
    double price;
    int num;
}

