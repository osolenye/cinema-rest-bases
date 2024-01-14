package com.example.cinema.exceptions;

public class PlaceIsOccupied extends RuntimeException{
    public PlaceIsOccupied(String mess){
        super(mess);
    }
}