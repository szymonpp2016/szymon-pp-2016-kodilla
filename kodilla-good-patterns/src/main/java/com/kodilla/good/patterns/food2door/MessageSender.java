package com.kodilla.good.patterns.food2door;



class MessageSender {
    private Admin admin;

    void welcomeMessage(Admin admin) {
        this.admin=admin;
    System.out.println("\n Welcome to the online store management center.");
    System.out.println("You are logged in as: "+admin.getUserName());
    }
}
