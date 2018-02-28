package com.kodilla.good.patterns.challenges;

public class BuildingStuffService implements OrderServiceRule {
    public boolean sell (User user, Order order){

        System.out.println("Order nr: " + order.getOrderNumber() +
                "\nSelling: " + order.getProduct() +
                "\nQuantity: " + order.getQuantity() +
                "\nunit: " + order.getUnit() +
                "\nPrice per unit: " + order.getCurrency() + " " + order.getPrice() +
                "\nTo: " + user.getName() + " " + user.getSurname());

        return true;
    }
}
