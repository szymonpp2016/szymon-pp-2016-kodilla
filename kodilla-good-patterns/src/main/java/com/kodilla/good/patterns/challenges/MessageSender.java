package com.kodilla.good.patterns.challenges;

public class MessageSender {

    public void goodByeMessage(User user) {
        System.out.println("Uzytkowniku: " + user.getName() + " " + user.getSurname()+" - dziękujemu za zakupy i zapraszamy ponownie!");
    }
    public void wellcomeMessage(User user) {
        System.out.println("Witamy uzytkownika: "+user.getName()+" "+user.getSurname());
    }
}

