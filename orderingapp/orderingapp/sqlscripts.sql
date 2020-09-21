CREATE DATABASE orderdb;

create table ordersys(hotelid INT PRIMARY KEY,hotelname VARCHAR (50) NOT NULL,checkindate date NOT NULL,checkoutdate date NOT NULL,custname VARCHAR (50) NOT NULL,custemail VARCHAR (50),custphone VARCHAR (50) NOT NULL,roomid INT NOT NULL,roomname VARCHAR (50) NOT NULL,noofguest INT NOT NULL,totalamount INT  NOT NULL);


