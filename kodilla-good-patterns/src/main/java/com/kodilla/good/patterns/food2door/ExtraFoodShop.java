package com.kodilla.good.patterns.food2door;

import java.util.concurrent.TimeUnit;

public class ExtraFoodShop implements IproducerCompany {

    private ExtraFoodShopRetriver extraFoodShopRetriver = new ExtraFoodShopRetriver();

    public OrderDto process(Order order) {

        System.out.println("Sending order to extraFoodShop");
        System.out.println("Wiating for serwer answer...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean confirmOrder =   extraFoodShopRetriver.extraFoodShop(order);

        return new OrderDto(order, confirmOrder);
    }
}
