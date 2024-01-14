package com.example.cinema.base;

import com.example.cinema.models.enums.Language;
import com.example.cinema.models.responses.Response;

import java.util.List;

public interface BaseService <D extends BaseDto> {
    D save(D d);
    D findById(Long id, Language language);
    List<D> findAll();
    D update(D d);

    boolean delete(D d);
}
