package com.example.cinema.exceptions;

public class FindByIdException extends RuntimeException{
    public FindByIdException(String message) {
        super(message);
    }
}
