package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class KindPizzaDecorator extends AbstractPizzaOrderDecorator {

    public enum KindOfPizza {
        AMERICAN("American pizza", "2.00"),
        ITALIEN("Orginal Italien pizza", "3.00");

        String name;
        BigDecimal price;

        KindOfPizza(String name, String cost) {
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

    private KindOfPizza kindOfPizza;

    KindPizzaDecorator(PizzaOrder pizzaOrder, KindOfPizza kindOfPizza) {
        super(pizzaOrder);
        this.kindOfPizza = kindOfPizza;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(kindOfPizza.price());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + kindOfPizza.name;
    }
}