package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order_details")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order", nullable = false)
    Order order;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_session", nullable = false)
    Session session;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_seats", nullable = false)
    Seat seats;
    double price;
    int num;
}