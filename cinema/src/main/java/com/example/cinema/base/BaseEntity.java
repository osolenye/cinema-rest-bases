package com.example.cinema.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    protected Date addDate;
    protected Date updateDate;
    protected boolean active = true;

    @PrePersist
    protected void onCreate() {
        addDate = new Date();
        updateDate = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        updateDate = new Date();
    }
}
