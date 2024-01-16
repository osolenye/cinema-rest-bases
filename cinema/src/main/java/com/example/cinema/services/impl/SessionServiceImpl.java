package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.exceptions.NotUniqueException;
import com.example.cinema.exceptions.NumException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.CinemaMapper;
import com.example.cinema.mappers.FilmMapper;
import com.example.cinema.mappers.PriceMapper;
import com.example.cinema.mappers.SessionMapper;
import com.example.cinema.models.dto.*;
import com.example.cinema.models.entity.Price;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.enums.Ticket;
import com.example.cinema.models.requests.SessionCreateRequest;
import com.example.cinema.models.responses.CinemaHelp;
import com.example.cinema.models.responses.Room;
import com.example.cinema.models.responses.RoomMovieId;
import com.example.cinema.models.responses.SessionByMovieAndDateResponse;
import com.example.cinema.rep.SessionRep;
import com.example.cinema.services.*;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionServiceImpl extends BaseServiceImpl<Session, SessionRep, SessionDto, SessionMapper> implements SessionService {
    public SessionServiceImpl(SessionRep sessionRep, SessionMapper mapper, CycleAvoidingMappingContext context, FilmService filmService, HallService hallService, PriceService priceService, FilmMapper filmMapper, CinemaService cinemaService, CinemaMapper cinemaMapper, SessionMapper sessionMapper, PriceMapper priceMapper) {
        super(sessionRep, mapper, context);
        this.filmService = filmService;
        this.hallService = hallService;
        this.priceService = priceService;
        this.filmMapper = filmMapper;
        this.cinemaService = cinemaService;
        this.cinemaMapper = cinemaMapper;
        this.sessionMapper = sessionMapper;
        this.priceMapper = priceMapper;
    }

    private final FilmService filmService;
    private final HallService hallService;
    private final PriceService priceService;
    private final FilmMapper filmMapper;
    private final CinemaService cinemaService;
    private final CinemaMapper cinemaMapper;
    private final SessionMapper sessionMapper;
    private final PriceMapper priceMapper;


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
                    sessionDto.setCinema(hall.getCinema());
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

    @Override
    public List<SessionDto> findByFilm(FilmDto filmDto, Language language) {
        try {
            return mapper.toDtos(r.findByFilm(filmMapper.toEntity(filmDto, context)), context);
        } catch (FindByIdException e) {
            throw new FindByIdException(ResourceBundle.periodMess("notFound", language));
        }
    }

    @Override
    public List<SessionDto> findByDateTime(Date dateTime, Language language) {
        try {
            return mapper.toDtos(r.findByDateTime(dateTime), context);
        } catch (FindByIdException e) {
            throw new FindByIdException(ResourceBundle.periodMess("notFound", language));
        }
    }

    @Override
    public List<SessionDto> findByCinema(CinemaDto cinemaDto, Language language) {
        try {
            return mapper.toDtos(r.findByCinema(cinemaMapper.toEntity(cinemaDto, context)), context);
        } catch (FindByIdException e) {
            throw new FindByIdException(ResourceBundle.periodMess("notFound", language));
        }
    }

    @Override
    public List<SessionDto> findByCinemaAndDateTime(CinemaDto cinemaDto, Date dateTime, Language language) {
        try {
            return mapper.toDtos(r.findByCinemaAndDateTime(cinemaMapper.toEntity(cinemaDto, context), dateTime), context);



        } catch (FindByIdException e) {
            throw new FindByIdException(ResourceBundle.periodMess("notFound", language));
        }
    }

    @Override
    public List<SessionByMovieAndDateResponse> findByCinemaAndDatetimeFormatted(CinemaDto cinemaDto, Date dateTime, Language language) {
        try {
            List<SessionDto> sessionDtos = findByCinemaAndDateTime(cinemaDto, dateTime, language);
            List<RoomMovieId> roomMovieIds = new ArrayList<>();
            List<Room> rooms = new ArrayList<>();
            List<CinemaHelp> cinemaHelps = new ArrayList<>();
            List<SessionByMovieAndDateResponse> sessionByMovieAndDateResponses = new ArrayList<>();


            for (SessionDto sessionDto: sessionDtos) {
                //создаем инфу по билету
                RoomMovieId roomMovieId = new RoomMovieId();
                Price price = priceMapper.toEntity(sessionDto.getPrice(), context);
                if (price.getType().equals(Ticket.CHILDREN)) {
                    roomMovieId.setChildPrice(price.getPrice());
                } else {
                    roomMovieId.setStandartPrice(price.getPrice());
                }
                roomMovieId.setDateTime(sessionDto.getDateTime());
                roomMovieIds.add(roomMovieId);

                //создаем инфу по всем залам в которых идет фильм
                Room room = new Room();
                room.setHallName(sessionDto.getHall().getName());
//                List<RoomMovieId> roomMovieIds1 = new ArrayList<>();
//                System.out.println(room.getRoomMovieIds());
//                roomMovieIds1 = room.getRoomMovieIds();
//                roomMovieIds1.add(roomMovieId);
//                room.setRoomMovieIds(roomMovieIds1);
                room.setRoomMovieIds(roomMovieIds);
                rooms.add(room);

                //создаем уже инфу по кинотеатру
                CinemaHelp cinemaHelp = new CinemaHelp();
                cinemaHelp.setCinemaName(sessionDto.getCinema().getName());
//                List<Room> rooms1 = new ArrayList<>();
//                rooms1 = cinemaHelp.getRooms();
//                rooms1.add(room);
//                cinemaHelp.setRooms(rooms1);
                cinemaHelp.setRooms(rooms);
                cinemaHelps.add(cinemaHelp);

                SessionByMovieAndDateResponse sessionByMovieAndDateResponse = new SessionByMovieAndDateResponse();
                sessionByMovieAndDateResponse.setFilm(sessionDto.getFilm());
                sessionByMovieAndDateResponse.setCinemaHelps(cinemaHelps);
                sessionByMovieAndDateResponses.add(sessionByMovieAndDateResponse);
            }
            return sessionByMovieAndDateResponses;
        } catch (Exception e) {
//            throw new FindByIdException(ResourceBundle.periodMess("notFound", language));
            throw new RuntimeException(e.getMessage());
        }
    }


}
