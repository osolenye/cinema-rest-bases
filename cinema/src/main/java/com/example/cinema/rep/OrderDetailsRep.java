package com.example.cinema.rep;


import com.example.cinema.base.BaseRep;
import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.OrderDetailsDto;
import com.example.cinema.models.entity.OrderDetails;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.OrderDetailsCreateRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRep extends BaseRep<OrderDetails> {
}