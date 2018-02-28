package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;

public class OrderPaymentDate {

    private double price;
    private String currency;
    private LocalDate orderdate;

    OrderPaymentDate(double price, String currency, LocalDate orderdate) {

        this.price = price;
        this.currency = currency;
        this.orderdate = orderdate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }
}
