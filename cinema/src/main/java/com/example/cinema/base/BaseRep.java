package com.example.cinema.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRep <E extends BaseEntity> extends JpaRepository<E, Long> {
    @Override
    Optional<E> findById(Long aLong);
}
