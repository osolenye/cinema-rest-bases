package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.NotUniqueException;
import com.example.cinema.exceptions.NumException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.SessionMapper;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.dto.PriceDto;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.models.responses.Response;
import com.example.cinema.rep.SessionRep;
import com.example.cinema.services.FilmService;
import com.example.cinema.services.HallService;
import com.example.cinema.services.PriceService;
import com.example.cinema.services.SessionService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

@Service
public class SessionServiceImpl extends BaseServiceImpl<Session, SessionRep, SessionDto, SessionMapper> implements SessionService {
    public SessionServiceImpl(SessionRep sessionRep, SessionMapper mapper, CycleAvoidingMappingContext context, FilmService filmService, HallService hallService, PriceService priceService) {
        super(sessionRep, mapper, context);
        this.filmService = filmService;
        this.hallService = hallService;
        this.priceService = priceService;
    }

    private final FilmService filmService;
    private final HallService hallService;
    private final PriceService priceService;


    @Override
    public SessionDto create(SessionCreateRequest request, Language language) {
        SessionDto sessionDto = new SessionDto();
        try {
            HallDto hall = hallService.findById(request.getHallId(), language);
            FilmDto film = filmService.findById(request.getFilmId(), language);
            PriceDto price = priceService.findById(request.getPriceId(), language);
            if(Objects.nonNull(hall) && Objects.nonNull(film) && Objects.nonNull(price)) {
                if (price.getPrice() > 0) {
                    sessionDto.setHall(hall);
                    sessionDto.setFilm(film);
                    sessionDto.setPrice(price);
                    sessionDto.setDateTime(request.getDateTime());
                    sessionDto.setDiscount(request.getDiscount());
                    return save(sessionDto);
                }else {
                    throw new NumException(ResourceBundle.periodMess("priceIsNegative", language));
                }
            } else {
                throw new NotUniqueException(ResourceBundle.periodMess("idNotFound", language));
            }
            } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }
}