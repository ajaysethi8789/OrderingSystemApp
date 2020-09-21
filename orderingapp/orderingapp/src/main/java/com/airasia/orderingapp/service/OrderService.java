package com.airasia.orderingapp.service;

import com.airasia.orderingapp.adapter.OrderAdapter;
import com.airasia.orderingapp.dbadapter.OrderDB;
import com.airasia.orderingapp.exception.OrderException;
import com.airasia.orderingapp.model.OrderInput;
import com.airasia.orderingapp.utils.OrderUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OrderService implements OrderAdapter {

    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    @Autowired
    OrderDB orderDB;

    @Autowired
    OrderUtils orderUtils;

    public String createOrder(OrderInput orderIn) throws SQLException, ClassNotFoundException, OrderException {
        LOGGER.info("Order Service class :: create Order func");
        String insertStatus;
        try{
            orderUtils.validateInput(orderIn);
            boolean resp = orderDB.createOrder(orderIn);
            if(resp){
                insertStatus = "Order has been created successfully!!";
            }
            else{
                insertStatus = "Error Occurred in create order";
            }
        }
        catch(Exception e){
            insertStatus = "failed";
            LOGGER.error("Order Service Catch Block "+e.getMessage());
            throw e;
        }

        return insertStatus;
    }
}
