package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.NumException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.OrderMapper;
import com.example.cinema.models.dto.OrderDto;
import com.example.cinema.models.entity.Order;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderCreateRequest;
import com.example.cinema.rep.OrderRep;
import com.example.cinema.services.OrderService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRep, OrderDto, OrderMapper> implements OrderService {


    public OrderServiceImpl(OrderRep orderRep, OrderMapper mapper, CycleAvoidingMappingContext context) {
        super(orderRep, mapper, context);
    }

    @Override
    public OrderDto create(OrderCreateRequest request, Language language) {
        try{
            if(request.getTotalPrice() > 0) {
                OrderDto orderDto = new OrderDto();
                orderDto.setTotalPrice(request.getTotalPrice());
                orderDto.setNum(request.getNum());
                return save(orderDto);
            }else {
                throw new NumException(ResourceBundle.periodMess("priceIsNegative", language));
            }
        }catch (UnsavedDataException e){
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }
}
