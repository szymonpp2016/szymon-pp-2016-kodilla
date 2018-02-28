package com.kodilla.good.patterns.food2door;

public class ProductOrderService {

    public OrderDto sendingOrderToCompany(Order order) {

        OrderDto confirmOrder;
        confirmOrder =new OrderDto(order,false);

        switch (order.getOrderProductDate().getSuplier()){
            case "suplier1":
                confirmOrder = new ExtraFoodShop().process(order);
                break;
            case "suplier2":
                confirmOrder = new GlutenFreeShop().process(order);
                break;
            case "suplier3":
                confirmOrder = new HealthyShop().process(order);
                break;
            default :
                System.out.println("Invalid suplier");
        }
        System.out.println("\n Thank you for using ours aplication!");
        return confirmOrder;
    }
}


