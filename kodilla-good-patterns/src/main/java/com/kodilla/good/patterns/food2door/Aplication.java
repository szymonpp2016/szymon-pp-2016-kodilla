package com.kodilla.good.patterns.food2door;

public class Aplication {

    public static void main(String[] args) {

        OrderRetriver orderRetriver = new OrderRetriver();
        MessageSender messageSender = new MessageSender();

        messageSender. welcomeMessage (new Admin("admin1"));

        new ShowRequest(orderRetriver.sellInformation().getOrder());

        ProductOrderService productOrderService = new ProductOrderService();
        OrderDto confirm =productOrderService.sendingOrderToCompany(orderRetriver.sellInformation().getOrder());

        new ReportGenarator(confirm).writeToFile();
    }
}
