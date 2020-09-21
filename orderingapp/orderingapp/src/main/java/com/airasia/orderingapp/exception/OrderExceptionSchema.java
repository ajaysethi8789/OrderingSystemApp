package com.airasia.orderingapp.exception;

public class OrderExceptionSchema {

    private int hotelId;
    private int code;
    private String message;

    public OrderExceptionSchema(){}

    public OrderExceptionSchema(int hotelId, int code, String message) {
        this.hotelId = hotelId;
        this.code = code;
        this.message = message;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
