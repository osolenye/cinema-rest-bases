package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.exceptions.NotUniqueException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.HallMapper;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.entity.Hall;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.HallCreateRequest;
import com.example.cinema.rep.HallRep;
import com.example.cinema.services.CinemaService;
import com.example.cinema.services.HallService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class HallServiceImpl extends BaseServiceImpl<Hall, HallRep, HallDto, HallMapper> implements HallService {
    public HallServiceImpl(HallRep hallRep, HallMapper mapper, CycleAvoidingMappingContext context, CinemaService cinemaService) {
        super(hallRep, mapper, context);
        this.cinemaService = cinemaService;
    }
    private final CinemaService cinemaService;

    @Override
    public HallDto create(HallCreateRequest request, Language language) {
        try {
            CinemaDto cinemaDto = cinemaService.findById(request.getCinemaId(), language);

            if (Objects.nonNull(cinemaDto)) {
                if (!r.existsByName(request.getName())) {
                    HallDto hallDto = new HallDto();
                    hallDto.setName(request.getName());
                    hallDto.setCinema(cinemaDto);
                    hallDto.setSeatRows(request.getSeatRows());
                    hallDto.setSeatCount(request.getSeatCount());

                    return save(hallDto);

                } else {
                    throw new NotUniqueException(ResourceBundle.periodMess("notUniqueName", language));
                }
            } else {
                throw new FindByIdException(ResourceBundle.periodMess("idNotFound", language));
            }

        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }
}
