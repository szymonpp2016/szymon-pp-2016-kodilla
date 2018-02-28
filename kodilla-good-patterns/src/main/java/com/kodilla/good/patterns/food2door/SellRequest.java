package com.kodilla.good.patterns.food2door;

public class SellRequest {

    private User user;
    private Order order;


    SellRequest(User user, Order order) {
        this.user = user;
        this.order  = order ;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }
}
