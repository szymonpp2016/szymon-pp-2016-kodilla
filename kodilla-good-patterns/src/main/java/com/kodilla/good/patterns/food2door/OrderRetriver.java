package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;

public class OrderRetriver {

    public SellRequest sellInformation() {

        User user = new User("Jan", "Nowak", "janNowak@polska.pl");
        OrderProductDate orderProductDate = new OrderProductDate(1, "pietruszka", "suplier3",10, "kg");
        OrderPaymentDate orderPaymentDate = new OrderPaymentDate(7.99, "PLN", LocalDate.of(2112,11,11));
        Order order = new Order(orderProductDate,orderPaymentDate);
        return new SellRequest(user,order);
    }
}
