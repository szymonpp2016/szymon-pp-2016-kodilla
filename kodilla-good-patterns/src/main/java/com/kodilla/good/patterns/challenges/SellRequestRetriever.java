package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class SellRequestRetriever {

    public SellRequest sellInformation() {

        User user = new User("Jan", "Nowak", "janNowak@polska.pl");
        Order order = new Order(1, "Concrete C20/C25", 10, "tons",7.99, "PLN", LocalDate.of(2112,11,11));

        return new SellRequest(user, order);
    }
}
