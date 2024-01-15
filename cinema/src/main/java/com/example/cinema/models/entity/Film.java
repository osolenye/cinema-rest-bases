package com.example.cinema.models.entity;

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
@Entity
@Table(name = "tb_film")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String logo;
    String definition;
    @Enumerated(EnumType.STRING)
    Genre genre;
    String ageRestrictions;
    @Enumerated(EnumType.STRING)
    Format format;

}