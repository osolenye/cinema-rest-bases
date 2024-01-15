package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.exceptions.PlaceIsOccupied;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.SeatMapper;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.entity.Seat;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.SeatCreateRequest;
import com.example.cinema.rep.SeatRep;
import com.example.cinema.services.HallService;
import com.example.cinema.services.SeatService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SeatServiceImpl extends BaseServiceImpl<Seat, SeatRep, SeatDto, SeatMapper> implements SeatService {
    public SeatServiceImpl(SeatRep seatRep, SeatMapper mapper, CycleAvoidingMappingContext context, HallService hallService) {
        super(seatRep, mapper, context);
        this.hallService = hallService;
    }

    private final HallService hallService;

    @Override
    public SeatDto create(SeatCreateRequest request, Language language) {
        try {
            HallDto hallDto = hallService.findById(request.getHallId(), language);
            if (!Objects.isNull(hallDto)) {
                SeatDto seatDto = new SeatDto();
                seatDto.setSeat(request.getSeat());
                seatDto.setHall(hallService.findById(request.getHallId(), language));
                return save(seatDto);
            } else {
                throw new FindByIdException(ResourceBundle.periodMess("idNotFound", language));
            }

        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }

}
