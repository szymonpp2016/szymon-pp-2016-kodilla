package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CheeseOrderDecorator extends AbstractPizzaOrderDecorator{
    public enum Cheese {
        MOZZARELLA("Mozzarella", "8.00"),
        GOUDA("Gouda", "6.00");
        String name;
        BigDecimal price;

        Cheese(String name, String cost) {
            this.name = name;
            this.price = new BigDecimal(cost);
        }

        public String toString() {
            return name;
        }
        public BigDecimal price() {
            return price;
        }
    }

    private Cheese cheese;

    CheeseOrderDecorator(PizzaOrder pizzaOrder, Cheese cheese) {
        super(pizzaOrder);
        this.cheese = cheese;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(cheese.price());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " \n - cheese: " + cheese.name;
    }
}
