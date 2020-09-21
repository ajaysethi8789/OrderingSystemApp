package com.airasia.orderingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public final ResponseEntity<Object> handleAllExceptions(OrderException ex) {
        OrderExceptionSchema exceptionResponse =
                new OrderExceptionSchema(ex.getHotelId(),ex.getCode(),ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
