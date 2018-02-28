package com.kodilla.good.patterns.food2door;

public class Order {

    private OrderProductDate orderProductDate;
    private OrderPaymentDate orderPaymentDate;

    Order(OrderProductDate orderProductDate, OrderPaymentDate orderPaymentDate) {
        this.orderPaymentDate = orderPaymentDate;
        this.orderProductDate = orderProductDate;
    }

    public OrderProductDate getOrderProductDate() {
        return orderProductDate;
    }

    public OrderPaymentDate getOrderPaymentDate() {
        return orderPaymentDate;
    }
}
