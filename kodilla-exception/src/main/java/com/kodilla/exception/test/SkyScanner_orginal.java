package com.kodilla.exception.test;


import java.util.HashMap;
import java.util.Map;

public class SkyScanner_orginal {
    private void FindFilght(Flight flight) throws RouteNotFoundException {

        HashMap<String, Boolean> airporst = Airports();

        if (airporst.containsKey(flight.getArrivalAirport())
                && airporst.containsKey(flight.getDepartureAirport())
                && airporst.get(flight.getDepartureAirport())
                && airporst.get(flight.getArrivalAirport())) {
            System.out.println("\n Wyberz godzine odlotu: \n 4:34, 23:59 \n");
        } else {
            throw new RouteNotFoundException();
        }
    }

    public static void main(String[] args) throws RouteNotFoundException {

        SkyScanner_orginal skyScanner = new SkyScanner_orginal();
        HashMap<String, Boolean> airportsList = skyScanner.Airports();
        Flight flight1 = new Flight("Warszawa", "Pekin1");

        System.out.println("Witamy w wyszukiwarce lotów \n");
        System.out.println("poniżej lotniska do których latamy: \n");
        for (Map.Entry<String, Boolean> entry : airportsList.entrySet()) {

            System.out.println("Airports: " + entry.getKey() + "-dostępność lotniska w dzisiejszym dniu: " +
                    entry.getValue());
        }

        System.out.println("\n Wybierz lotnisko wylotu oraz cel podróży:");
        System.out.println("wybrano:" + flight1.getDepartureAirport() + " " + flight1.getArrivalAirport());

        try {
            skyScanner.FindFilght(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Nie ma takiego lotniska w ofercie lub lotnisko jest nieczynne");
            System.out.println("(sprawdź czy poprawnie wpisałeś nazwę lotniska)");
        } finally {
            System.out.println("\n Zapraszamy do korzystania z naszych lotów");
        }
    }

    private HashMap<String, Boolean> Airports() {
        HashMap<String, Boolean> flightsMap = new HashMap<>();

        flightsMap.put("Warszawa", true);
        flightsMap.put("Christchurch", true);
        flightsMap.put("Porto", true);
        flightsMap.put("Pekin", false);
        return flightsMap;
    }

}