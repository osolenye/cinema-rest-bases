package com.example.cinema.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseDto {
    protected Long id;
    protected Date addDate;
    protected Date updateDate;
    protected boolean active = true;
}
