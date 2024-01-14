package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.mappers.CinemaMapper;
import com.example.cinema.microservices.FileServiceFeign;
import com.example.cinema.microservices.jsons.FileResponse;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.rep.CinemaRep;
import com.example.cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CinemaServiceImpl extends BaseServiceImpl<Cinema, CinemaRep, CinemaDto, CinemaMapper> implements CinemaService {



    @Autowired
    private final FileServiceFeign fileServiceFeign;

    public CinemaServiceImpl(CinemaRep cinemaRep, CinemaMapper mapper, CycleAvoidingMappingContext context, FileServiceFeign fileServiceFeign) {
        super(cinemaRep, mapper, context);
        this.fileServiceFeign = fileServiceFeign;
    }


    @Override
    public CinemaDto create(MultipartFile logo, CinemaCreateRequest request) {
        CinemaDto cinemaDto = new CinemaDto();
        cinemaDto.setName(request.getName());
        cinemaDto.setDescription(request.getDescription());
        FileResponse fileResponse = fileServiceFeign.upload(request.getLogo());
        cinemaDto.setLogo(fileResponse.getDownloadUri());
        return save(cinemaDto);
    }
}