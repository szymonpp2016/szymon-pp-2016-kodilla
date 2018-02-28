package com.kodilla.good.patterns.food2door;

import java.util.concurrent.TimeUnit;

public class GlutenFreeShop implements IproducerCompany {
    private GlutenFreeShopRetriver glutenFreeShopRetriver = new GlutenFreeShopRetriver();

     public OrderDto process(Order order) {

         System.out.println("Sending order to glutenFreeShop!");
         System.out.println("Wiating for serwer answer...");
         try {
             TimeUnit.SECONDS.sleep(2);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         boolean confirmOrder =   glutenFreeShopRetriver.glutenFreeShop(order);

         return new OrderDto(order, confirmOrder);
     }
}
