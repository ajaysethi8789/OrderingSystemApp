package com.airasia.orderingapp.adapter;
import com.airasia.orderingapp.exception.OrderException;
import com.airasia.orderingapp.model.OrderInput;

import java.sql.SQLException;

public interface OrderAdapter {
    public String createOrder(OrderInput order) throws SQLException, ClassNotFoundException, OrderException;
}
