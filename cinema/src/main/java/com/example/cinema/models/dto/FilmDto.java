package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import com.example.cinema.base.BaseEntity;
import com.example.cinema.models.enums.Format;
import com.example.cinema.models.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmDto extends BaseDto{
    Long id;
    String name;
    String logo;
    String definition;
    Genre genre;
    String ageRestrictions;
    Format format;
}