package com.shakov.goodbuyproject.html.exception;

public class SeleniumInterruptedException extends RuntimeException{

    public SeleniumInterruptedException(String message) {
        super(message);
    }
}