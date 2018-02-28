package com.kodilla.good.patterns.food2door;

class ShowRequest {

    ShowRequest(Order order) {

        System.out.println(" \n The order nr " + order.getOrderProductDate().getOrderNumber()
                +" \n   Product:  " +order.getOrderProductDate().getProduct()+" \n From shop: "+ order.getOrderProductDate().getSuplier()+"\n");
    }
}
