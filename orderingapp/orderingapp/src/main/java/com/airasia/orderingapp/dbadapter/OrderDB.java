package com.airasia.orderingapp.dbadapter;

import com.airasia.orderingapp.model.OrderInput;
import com.airasia.orderingapp.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrderDB {

    private static final Logger LOGGER = LogManager.getLogger(OrderDB.class);
    @Autowired
    private PostgreSqlConnection postgreSQLConn;

    Connection connection = null;

    public boolean createOrder(OrderInput orderInput) throws SQLException, ClassNotFoundException {
        LOGGER.info("OrderDB ::  create order ::  db input data "+orderInput.toString());
        boolean status = true;
        try {
        String createOrderQuery = "INSERT INTO ordersys(hotelid, hotelname, checkindate,checkoutdate,custname,custemail,custphone,roomid,roomname,noofguest,totalamount)" +
                " VALUES ('" + orderInput.getHotelId() + "','"+ orderInput.getHotelName() + "','" + orderInput.getCheckInDate() + "','" + orderInput.getCheckOutDate() +"','"+orderInput.getCustomerName() + "','" + orderInput.getCustomerEmailId() +"','"+ orderInput.getCustomerContactNo() + "','" + orderInput.getRoomId() + "','" + orderInput.getRoomName() + "','" + orderInput.getNoOfGuests() + "','" + orderInput.getTotalAmount() + "');";
        LOGGER.debug("SQL query "+createOrderQuery);
        ResultSet rs = postgreSQLConn.queryDB(connection,createOrderQuery);

        } catch (Exception e) {
            System.out.println("Order DB  Catch : Message " + e.getMessage());
            e.printStackTrace();
            status = false;
            throw e;
        }
        return status;
    }
}
