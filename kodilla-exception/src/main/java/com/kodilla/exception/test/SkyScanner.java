package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SkyScanner {

    private SkyScanner() {
        prepareFlightSchedule();
    }

    private HashMap <String,Boolean> prepareFlightSchedule() {
        HashMap<String, Boolean>flightSchedule = new HashMap<>();
        flightSchedule.put("WARSZAWA",true);
        flightSchedule.put("CHRISTCHURCH",true);
        flightSchedule.put("PORTO",true);
        flightSchedule.put("PEKIN",false);
        return flightSchedule;
    }

    private void findFilght(Flight flight) throws RouteNotFoundException {

        if(prepareFlightSchedule().get(flight.getDepartureAirport())
                &&prepareFlightSchedule().get(flight.getArrivalAirport())) {
            System.out.println("\n Możliwe godzine wylotu: \n 4:34, 23:59 \n");
        }
        else {
            throw new RouteNotFoundException();
        }
    }

    public static void main(String[] args)  {

        SkyScanner skyScanner = new SkyScanner();

        System.out.println("Witamy w wyszukiwarce lotów \n");
        System.out.println("poniżej lotniska do których latamy: \n");
        for (Map.Entry<String, Boolean> entry : skyScanner.prepareFlightSchedule().entrySet()) {

            System.out.println("Airports: " + entry.getKey() + ", dostępność lotniska w dzisiejszym dniu: " +
                    entry.getValue());
        }

        System.out.println("\n Wybierz lotnisko wylotu oraz cel podróży:");

        String arrival;
        String departure;
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj Lotniska staru:");
        departure = odczyt.nextLine();
        System.out.println("Podaj Lotnisko docelowe:");
        arrival = odczyt.nextLine();

        Flight flight1 = new Flight(departure.toUpperCase(), arrival.toUpperCase());
        try {
            skyScanner.findFilght(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Lotnisko jest nieczynne");

        } catch (NullPointerException e) {
            System.out.println("Nie ma takiego lotniska w ofercie ");
            System.out.println("(sprawdź czy poprawnie wpisałeś nazwę lotniska)");
        }
        finally {
            System.out.println("\n Zapraszamy do korzystania z naszych lotów!");
        }
    }
}
