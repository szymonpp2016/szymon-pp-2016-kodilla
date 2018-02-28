package com.kodilla.good.patterns.challenges;

public class Aplication {

    public static void main(String[] args) {

        SellRequestRetriever sellRequestRetriever = new SellRequestRetriever();
        MessageSender messageSender = new MessageSender();

        messageSender.wellcomeMessage(sellRequestRetriever.sellInformation().getUser());

        ProductOrderService productOrderService = new ProductOrderService(
                new PagerService(),
                new BuildingStuffService(),
                new BuildingRepositoryService() );

        productOrderService.process(sellRequestRetriever.sellInformation());

        messageSender.goodByeMessage(sellRequestRetriever.sellInformation().getUser());
    }
}
