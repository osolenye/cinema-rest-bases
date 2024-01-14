package com.example.cinema.services.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.base.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.UnsavedDataException;
import com.example.cinema.mappers.PriceMapper;
import com.example.cinema.models.dto.PriceDto;
import com.example.cinema.models.entity.Price;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.requests.PriceCreateRequest;
import com.example.cinema.rep.PriceRep;
import com.example.cinema.services.PriceService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl extends BaseServiceImpl<Price, PriceRep, PriceDto, PriceMapper> implements PriceService {
    public PriceServiceImpl(PriceRep priceRep, PriceMapper mapper, CycleAvoidingMappingContext context, PriceRep priceRep1) {
        super(priceRep, mapper, context);
        this.priceRep = priceRep1;
    }
    private final PriceRep priceRep;

    @Override
    public PriceDto create(PriceCreateRequest request, Language language) {
        try {
            PriceDto priceDto = new PriceDto();
            priceDto.setPrice(request.getPrice());
            priceDto.setType(request.getType());
            return save(priceDto);
        } catch (UnsavedDataException e) {
            throw new UnsavedDataException(ResourceBundle.periodMess("unsavedData", language));
        }
    }
}
