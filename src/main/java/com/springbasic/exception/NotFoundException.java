package com.springbasic.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String messsage) {
        super(messsage);
    }
}
