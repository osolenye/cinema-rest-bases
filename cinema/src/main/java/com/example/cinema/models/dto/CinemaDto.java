package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDto extends BaseDto {
    String logo;
    String name;
    String description;

}
