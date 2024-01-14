package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "tb_hall")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Hall extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "name", unique = true, nullable = false)
    String name;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cinema")
    Cinema cinema;
    @Column(nullable = false)
    int seatRows;
    @Column(nullable = false)
    int seatCount;
}