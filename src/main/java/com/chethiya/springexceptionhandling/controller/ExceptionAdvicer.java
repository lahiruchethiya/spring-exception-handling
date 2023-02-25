package com.chethiya.springexceptionhandling.controller;

import com.chethiya.springexceptionhandling.exception.OrderServiceException;
import com.chethiya.springexceptionhandling.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvicer {

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<OrderError> mapexception(OrderServiceException ex) {
        OrderError error = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<OrderError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
