package com.kodilla.good.patterns.flights;

import java.util.concurrent.TimeUnit;

public class BuyTicketProcessor {

   static public void buyTicketProcessor() {  //normalnie to by była dyn. funkcja pobierajaca arrival,
       // departure -ale to już za z dużo zabawy jak na ta chwile :)

        System.out.println("zostaniesz przekierowany do modułu kupna biletu ->");
        try {
            System.out.print("\n .");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" connection! \n\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
