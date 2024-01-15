package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.exceptions.NotUniqueException;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.CinemaMapper;
import com.example.cinema.microservices.FileServiceFeign;
import com.example.cinema.microservices.jsons.FileResponse;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.CinemaCreateRequest;
import com.example.cinema.models.responses.Response;
import com.example.cinema.rep.CinemaRep;
import com.example.cinema.services.CinemaService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.naming.ldap.LdapName;
import java.util.List;

@Service
public class CinemaServiceImpl extends BaseServiceImpl<Cinema, CinemaRep, CinemaDto, CinemaMapper> implements CinemaService {



    @Autowired
    private final FileServiceFeign fileServiceFeign;

    public CinemaServiceImpl(CinemaRep cinemaRep, CinemaMapper mapper, CycleAvoidingMappingContext context, FileServiceFeign fileServiceFeign) {
        super(cinemaRep, mapper, context);
        this.fileServiceFeign = fileServiceFeign;
    }


    @Override
    public CinemaDto create(MultipartFile logo, CinemaCreateRequest request, Language language) {
        try {
            if (!r.existsByName(request.getName())) {
                CinemaDto cinemaDto = new CinemaDto();
                cinemaDto.setName(request.getName());
                cinemaDto.setDescription(request.getDescription());
                FileResponse fileResponse = fileServiceFeign.upload(request.getLogo());
                cinemaDto.setLogo(fileResponse.getDownloadUri());
                return save(cinemaDto);
            } else {
                throw new NotUniqueException(ResourceBundle.periodMess("notUniqueName", language));
            }
        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }

    @Override
    public CinemaDto findByName(String name, Language language) {
        try {
            return mapper.toDto(r.findByName(name), context);
        } catch (Exception e) {
            throw new NotUniqueException(ResourceBundle.periodMess("idNotFound", language));
        }
    }

    @Override
    public List<CinemaDto> findAll(Language language) {
        try {
            return mapper.toDtos(r.findAll(), context);
        } catch (Exception e) {
            throw new FindByIdException(ResourceBundle.periodMess("notFound", language));
        }
    }
}