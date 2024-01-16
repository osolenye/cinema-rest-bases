package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.SeatMapper;
import com.example.cinema.mappers.SessionMapper;
import com.example.cinema.models.dto.SeatDto;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.Seat;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.enums.SeatStatus;
import com.example.cinema.models.requests.SeatCreateRequest;
import com.example.cinema.rep.SeatRep;
import com.example.cinema.services.HallService;
import com.example.cinema.services.SeatService;
import com.example.cinema.services.SessionService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SeatServiceImpl extends BaseServiceImpl<Seat, SeatRep, SeatDto, SeatMapper> implements SeatService {
    public SeatServiceImpl(SeatRep seatRep, SeatMapper mapper, CycleAvoidingMappingContext context, HallService hallService, SessionService sessionService, SessionMapper sessionMapper) {
        super(seatRep, mapper, context);
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    @Override
    public SeatDto create(SeatCreateRequest request, SeatStatus status, Language language) {
        try {
//            HallDto hallDto = hallService.findById(request.getHallId(), language);
            SessionDto sessionDto = sessionService.findById(request.getSessionId(), language);
            if (!Objects.isNull(sessionDto)) {
                SeatDto seatDto = new SeatDto();
                seatDto.setSeat(request.getSeat());
                seatDto.setStatus(status);
                seatDto.setSession(sessionService.findById(request.getSessionId(), language));
                return save(seatDto);
            } else {
                throw new FindByIdException(ResourceBundle.periodMess("idNotFound", language));
            }

        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }

    @Override
    public List<SeatDto> findByStatusAndSession(SeatStatus status, SessionDto session, Language language) {
        try {
            return mapper.toDtos(r.findByStatusAndSession(status, sessionMapper.toEntity(session, context)), context);
        } catch (FindByIdException e) {
            throw new FindByIdException(ResourceBundle.periodMess("nofFound", language));
        }
    }

}
