package datafactory;

import dataobjects.OrderDetails;

public class PlaceOrderData {
    OrderDetails order = new OrderDetails();

    public OrderDetails placeOrderData() {
        order.setName("TestUser");
        order.setCountry("India");
        order.setCity("Ahmedabad");
        order.setCreditcard("4343 0000 0000");
        order.setMonth("06");
        order.setYear("2023");
        return order;
    }
}
