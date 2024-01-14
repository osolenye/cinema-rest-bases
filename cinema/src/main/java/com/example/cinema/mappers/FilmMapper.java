package com.example.cinema.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.entity.Film;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")

public interface FilmMapper extends BaseMapper<Film, FilmDto> {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

}
