package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;

public class OrderProductDate {

    private int orderNumber;
    private String product;
    private String suplier;
    private int quantity;
    private String unit;


    OrderProductDate(final int orderNumber, final String product, final String suplier,
                     final int quantity, final String unit) {
        this.orderNumber = orderNumber;
        this.product = product;
        this.suplier=suplier;
        this.quantity = quantity;

        this.unit = unit;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getProduct() {
        return product;
    }

    public String getSuplier() {
        return suplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }


}
