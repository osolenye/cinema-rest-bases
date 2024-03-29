package com.example.cinema.models.entity;


import com.example.cinema.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_session")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Session extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_film", nullable = false)
    Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_hall", nullable = false)
    Hall hall;
    Date dateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_price", nullable = false)
    Price price;
    double discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cinema", nullable = false)
    Cinema cinema;
}