# OrderingSystemApp

Instructions to run the project : 
I have used the postgresql database, run the database script to create the database and the table (Attached sqlscripts.sql)
Configure the database properties like dbname, port and password in application.properties file.
Once database setup is done, bring the application up by running the OrderingSystemApplication.java file.
Post running the app, it would expose the createOrder API to be invoked by client applications.
To test the create Order API, I used a postman tool to invoke the same.

Method : Post
API URL : http://localhost:8081/api/1.0/order/createOrder
Request Body: 

{
    "hotelId":"1",
    "hotelName":"OYO",
    "checkInDate":"2020-09-21",
    "checkOutDate":"2022-09-27",
    "customerName":"Ajay Sethi",
    "customerEmailId":"ajaysethi@gmail.com",
    "customerContactNo":"0123456789",
    "roomId":"100",
    "roomName":"SilverKey",
    "noOfGuests":"2",
    "totalAmount":"1236"
}

Response Body:

{
    "code": "200",
    "hotelId": 132,
    "message": "Order has been created successfully!!"
}
