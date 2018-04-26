package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MainPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(2.0);
    }

    @Override
    public String getDescription() {
        return "You order: ";
    }
}