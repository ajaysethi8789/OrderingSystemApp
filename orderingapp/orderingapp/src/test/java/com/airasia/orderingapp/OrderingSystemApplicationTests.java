package com.airasia.orderingapp;

import com.airasia.orderingapp.exception.OrderException;
import com.airasia.orderingapp.model.OrderInput;
import com.airasia.orderingapp.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class OrderingSystemApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	public void unitTestCreateOrder() throws SQLException, ClassNotFoundException, OrderException {

		Date checkInDate = new Date(2020, 11, 21);
		Date checkOutDate = new Date(2020, 11, 29);
		OrderInput order = new OrderInput();
		order.setHotelId(6);
		order.setHotelName("OYO");
		order.setCheckInDate(checkInDate);
		order.setCheckOutDate(checkOutDate);
		order.setCustomerName("John");
		order.setCustomerEmailId("cust@gmail.com");
		order.setCustomerContactNo("9999999999");
		order.setRoomId(5000);
		order.setRoomName("silver key");
		order.setNoOfGuests(3);
		order.setTotalAmount(1990);

		String createOrderRes = orderService.createOrder(order);

		System.out.println("unit test create order result "+createOrderRes);

		Assertions.assertTrue(createOrderRes.equalsIgnoreCase("Order has been created successfully!!"));
	}



}
