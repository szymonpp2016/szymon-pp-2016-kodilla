package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Map;

public class ConnectionAvailabilityInform {

    private Airports airports ;

    ConnectionAvailabilityInform(Airports airports) {
        this.airports = airports;
    }

    void displayAllAirports() {
        System.out.println("Poniżej lotniska, z których i do których latamy: \n");
        for (Map.Entry<String, Boolean> entry : airports.prepareFlightSchedule().entrySet()) {
            System.out.println("Airport: " + entry.getKey() + ", dostępność lotniska w dzisiejszym dniu: " +
                    entry.getValue());
        }
    }


    void  displayDepartyAirports(Map<String,List<String>> destinyMap) {
        destinyMap.entrySet().iterator().next().getValue().forEach(System.out::println);
    }


    void flightsToDestination(boolean directlly)   {

        if (directlly) {
            System.out.println("Posiadamy loty bezpośrednie do tego miasta");
        } else {
            System.out.println("Nie posiadamy bezpośrednich lotów z tego lotniska!");
            System.out.println("Błedna nazwa, jedno z lotnisk jest nieczynne lub nie znaleziono lotu");
        }
    }


    void transferFlight(ListDto listDto){
        listDto.getList1().retainAll(listDto.getList());
        if(listDto.getList1().size()>0) {
            System.out.println("Możliwe loty z przesiadką w:");
            listDto.getList1().forEach(System.out::println);
        } else {
            System.out.println("Brak możliwych lotów na podanej trasie");
        }
    }
}
