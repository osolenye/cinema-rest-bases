package com.example.cinema.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.Session;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SessionMapper extends BaseMapper<Session, SessionDto> {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);
}
