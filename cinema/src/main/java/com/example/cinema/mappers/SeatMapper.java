package com.example.cinema.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.entity.Seat;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SeatMapper extends BaseMapper<Seat, SeatDto> {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
}