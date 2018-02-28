package com.kodilla.good.patterns.flights;

import java.util.Scanner;

public class SkyScanner {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        Airports airports = new Airports();
        FindFlightPorcessor findFlyProcessor = new FindFlightPorcessor(airports);
        ConnectionAvailabilityInform connectionAvailabilityInform = new ConnectionAvailabilityInform(airports);


        boolean directlly;

        System.out.println("Witamy w wyszukiwarce lotów! \n");
        connectionAvailabilityInform.displayAllAirports();

        System.out.println("\n Wybierz lotnisko wylotu oraz cel podróży:");
        System.out.println("Podaj lotniska startu:");
        final String departure = scanner.nextLine();

        try {
            System.out.println("Oto miasta do których posiadamy bezpośrenie loty:");
            connectionAvailabilityInform.displayDepartyAirports(findFlyProcessor.flightsFromDeparture(departure.toUpperCase()));

            System.out.println("Podaj lotnisko docelowe:");
            final String arrival = scanner.nextLine();

            Flight flight1 = new Flight(departure.toUpperCase(), arrival.toUpperCase());

            directlly = findFlyProcessor.flightsToDestination(flight1, findFlyProcessor.flightsFromDeparture(departure.toUpperCase()));
            connectionAvailabilityInform.flightsToDestination(directlly); //optionall

            if(!directlly) {
                System.out.println("Czy interesuje Cię lot z przesiadką (Y/N)?");
                String transfer = scanner.nextLine().toUpperCase();

                if (transfer.equals("Y")) {
                    findFlyProcessor.transferFlight(flight1);
                    connectionAvailabilityInform.transferFlight(findFlyProcessor.transferFlight(flight1)); //optionall
                }
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Lotnisko jest nieczynne");

        } catch (NullPointerException e) {
            System.out.println("Nie ma takiego lotniska w ofercie.");
            System.out.println("(sprawdź czy poprawnie wpisałeś nazwę lotniska)");
        }
        finally {
            System.out.println("\n Zapraszamy do korzystania z naszych lotów!");
        }
    }
}
