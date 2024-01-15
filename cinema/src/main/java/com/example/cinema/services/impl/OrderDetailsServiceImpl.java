package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.OrderDetailsMapper;
import com.example.cinema.mappers.SessionMapper;
import com.example.cinema.models.dto.OrderDetailsDto;
import com.example.cinema.models.dto.OrderDto;
import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.OrderDetails;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.enums.SeatStatus;
import com.example.cinema.models.requests.OrderDetailsCreateRequest;
import com.example.cinema.models.responses.OrderDetailsResponse;
import com.example.cinema.rep.OrderDetailsRep;
import com.example.cinema.services.OrderDetailsService;
import com.example.cinema.services.OrderService;
import com.example.cinema.services.SeatService;
import com.example.cinema.services.SessionService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderDetailsServiceImpl extends BaseServiceImpl<OrderDetails, OrderDetailsRep, OrderDetailsDto, OrderDetailsMapper>
        implements OrderDetailsService {

    public OrderDetailsServiceImpl(OrderDetailsRep orderDetailsRep, OrderDetailsMapper mapper, CycleAvoidingMappingContext context, OrderService orderService, SeatService seatService, SessionService sessionService, SessionMapper sessionMapper) {
        super(orderDetailsRep, mapper, context);
        this.orderService = orderService;
        this.seatService = seatService;
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    private final OrderService orderService;
    private final SeatService seatService;
    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    @Override
    public OrderDetailsResponse create(OrderDetailsCreateRequest request, Language lang) {
        try {
            OrderDto order = orderService.findById(request.getOrderId(), lang);
            SeatDto seats = seatService.findById(request.getSeatsId(), lang);
            SessionDto session = sessionService.findById(request.getSessionId(), lang);
            if (Objects.nonNull(order) && Objects.nonNull(seats) && Objects.nonNull(session)) {
                OrderDetailsDto orderDetails = new OrderDetailsDto();

                orderDetails.setOrder(order);
                orderDetails.setSession(session);
                orderDetails.setSeats(seats);
                if (session.getDiscount() > 0)
                    request.setPrice(countPriceWithDisc(session.getPrice().getPrice(), session.getDiscount()));
                orderDetails.setPrice(request.getPrice());
                orderDetails.setNum(request.getNum());
//                order.setTotalPrice(order.getTotalPrice() + orderDetails.getPrice());
                save(orderDetails);
                OrderDetailsResponse orderDetailsResponse = new OrderDetailsResponse();
                orderDetailsResponse.setYourSeats(seatService.findByStatusAndSession(SeatStatus.YOUR, session, lang));
                orderDetailsResponse.setFreeSeats(seatService.findByStatusAndSession(SeatStatus.FREE, session, lang));
                orderDetailsResponse.setOccupiedSeats(seatService.findByStatusAndSession(SeatStatus.OCCUPIED, session, lang));
                orderDetailsResponse.setTotalPrice(order.getTotalPrice());
                return orderDetailsResponse;
            } else {
                throw new FindByIdException(ResourceBundle.periodMess("idNotFound", lang));
            }
        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", lang));
        }
    }

    private double countPriceWithDisc(double price, double discount){
        price *= discount / 0.01;
        return price;
    }
}
