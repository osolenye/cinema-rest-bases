package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.FilmMapper;
import com.example.cinema.microservices.FileServiceFeign;
import com.example.cinema.microservices.jsons.FileResponse;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.entity.Film;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.requests.FilmCreateRequest;
import com.example.cinema.rep.FilmRep;
import com.example.cinema.services.FilmService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilmServiceImpl extends BaseServiceImpl<Film, FilmRep, FilmDto, FilmMapper> implements FilmService {


    public FilmServiceImpl(FilmRep filmRep, FilmMapper mapper, CycleAvoidingMappingContext context, FileServiceFeign fileServiceFeign) {
        super(filmRep, mapper, context);
        this.fileServiceFeign = fileServiceFeign;
    }

    private final FileServiceFeign fileServiceFeign;

    @Override
    public FilmDto create(MultipartFile logo, FilmCreateRequest request, Language language) {
        try {
            FilmDto filmDto = new FilmDto();
            filmDto.setName(request.getName());
            FileResponse fileResponse = fileServiceFeign.upload(logo);
            filmDto.setLogo(fileResponse.getDownloadUri());
            filmDto.setDefinition(request.getDefinition());
            filmDto.setGenre(request.getGenre());
            filmDto.setAgeRestrictions(request.getAgeRestrictions());
            filmDto.setFormat(request.getFormat());
            return save(filmDto);
        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }
}
