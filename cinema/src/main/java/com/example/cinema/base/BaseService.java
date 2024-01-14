package com.example.cinema.base;

import java.util.List;

public interface BaseService <D extends BaseDto> {
    D save(D d);
    D findById(Long id);
    List<D> findAll();
    D update(D d);

    boolean delete(D d);
}
