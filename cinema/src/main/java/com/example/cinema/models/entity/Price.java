package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import com.example.cinema.models.enums.Ticket;
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
@Table(name = "tb_price")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    double price;
    @Enumerated(EnumType.STRING)
    Ticket type;
}
