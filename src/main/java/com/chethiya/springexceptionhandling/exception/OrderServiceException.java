package com.chethiya.springexceptionhandling.exception;

public class OrderServiceException extends Exception{

    private static final Long serialVersionUID = 42L;

    public OrderServiceException(String message) {
        super(message);
    }
}
