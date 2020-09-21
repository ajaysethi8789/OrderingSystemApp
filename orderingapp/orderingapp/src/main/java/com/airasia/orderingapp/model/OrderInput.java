package com.airasia.orderingapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class OrderInput {

    @NotNull(message = "hotelId is mandatory")
    @Min(1)
    private int hotelId;
    @NotBlank(message = "hotelName is mandatory")
    private String hotelName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkOutDate;
    @NotBlank(message = "customerName is mandatory")
    private String customerName;
    @NotBlank(message = "customerEmailId is mandatory")
    private String customerEmailId;
    @Pattern(regexp="(^$|[0-9]{10})")
    @NotBlank(message = "customerContactNo is mandatory")
    private String customerContactNo;
    @Min(1)
    @NotNull(message = "roomId is mandatory")
    private int roomId;
    @NotBlank(message = "roomName is mandatory")
    private String roomName;
    @Min(1)
    @NotNull(message = "noOfGuests is mandatory")
    private int noOfGuests;
    @Min(1)
    @NotNull(message = "totalAmount is mandatory")
    private int totalAmount;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerContactNo() {
        return customerContactNo;
    }

    public void setCustomerContactNo(String customerContactNo) {
        this.customerContactNo = customerContactNo;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "OrderInput{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", customerName='" + customerName + '\'' +
                ", customerEmailId='" + customerEmailId + '\'' +
                ", customerContactNo='" + customerContactNo + '\'' +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", noOfGuests=" + noOfGuests +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
