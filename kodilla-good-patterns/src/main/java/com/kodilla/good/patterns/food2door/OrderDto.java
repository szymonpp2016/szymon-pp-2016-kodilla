package com.kodilla.good.patterns.food2door;

 class OrderDto {

    private Order order;
    private boolean confirmSendingOrder;

    OrderDto(Order order, boolean confirmSendingOrder) {
        this.order = order;
        this.confirmSendingOrder = confirmSendingOrder;
    }
     public Order getOrder() {
         return order;
     }
     public boolean isConfirmSendingOrder() {
         return confirmSendingOrder;
     }
 }
