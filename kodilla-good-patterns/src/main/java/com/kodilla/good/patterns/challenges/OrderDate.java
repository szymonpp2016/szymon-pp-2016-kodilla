package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderDate {

    private LocalDate orderDate;

    OrderDate(int year, int month, int day){
        this.orderDate = LocalDate.of(year, month, day);
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
