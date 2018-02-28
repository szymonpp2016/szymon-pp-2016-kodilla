package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class Order {

    private int orderNumber;
    private String product;
    private int quantity;
    private String unit;
    private double price;
    private String currency;
    private LocalDate orderdate;

    Order(final int orderNumber, final String product,
          final int quantity, final String unit, final double price,
          final String currency, LocalDate orderDate) {
        this.orderNumber = orderNumber;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.orderdate=orderDate;
        this.unit = unit;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public String getUnit() {
        return unit;
    }
}
