package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto extends BaseDto {
    Long id;
    double totalPrice;
    int num;
}