package com.example.cinema.exceptions;

public class TokenValidationException extends RuntimeException {
    public TokenValidationException(String mess) {
        super(mess);
    }
}
