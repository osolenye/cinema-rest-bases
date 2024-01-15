package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import com.example.cinema.models.enums.SeatStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_seat")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    int seat;
    @Enumerated(EnumType.STRING)
    SeatStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_session", nullable = false)
    Session session;

    @Override
    protected void onCreate() {
        super.onCreate();
//        status = SeatStatus.FREE;
    }
}