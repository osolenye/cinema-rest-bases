package com.example.cinema.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.OrderDetailsDto;
import com.example.cinema.models.entity.OrderDetails;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface OrderDetailsMapper extends BaseMapper<OrderDetails, OrderDetailsDto> {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);
}
