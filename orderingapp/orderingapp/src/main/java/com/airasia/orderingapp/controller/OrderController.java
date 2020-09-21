package com.airasia.orderingapp.controller;

import com.airasia.orderingapp.exception.OrderException;
import com.airasia.orderingapp.model.OrderInput;
import com.airasia.orderingapp.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
public class OrderController {

    private static final Logger LOGGER = LogManager.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;

    @PostMapping("/order/createOrder")
    public ResponseEntity<JSONObject> createOrder(@RequestBody OrderInput orderInput) throws Exception {

        LOGGER.info("Create Order API Invoked");

        LOGGER.info("Create Order Input Data "+orderInput.toString());
        JSONObject respJson = new JSONObject();
        String respMsg = null;
        try {
            respMsg = orderService.createOrder(orderInput);
            respJson.put("hotelId",orderInput.getHotelId());
            respJson.put("code", "200");
            respJson.put("message", respMsg);
            LOGGER.info("resp :: create order :: "+respJson.toString());
            return new ResponseEntity<JSONObject>(respJson, HttpStatus.OK);
        }
        catch(Exception e){
            LOGGER.error("Error Occurred in Create Order API "+e.getMessage());
            throw new OrderException(orderInput.getHotelId(),400,e.getMessage());
            }
    }
}
