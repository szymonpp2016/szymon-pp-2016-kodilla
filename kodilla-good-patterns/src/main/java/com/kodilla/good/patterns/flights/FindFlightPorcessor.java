package com.kodilla.good.patterns.flights;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public class FindFlightPorcessor {

    private Airports airports ;

   FindFlightPorcessor(Airports airports) {
        this.airports = airports;
    }


    public Map<String, List<String>> flightsFromDeparture(String departure) throws RouteNotFoundException {
        if (airports.prepareFlightSchedule().get(departure)) {
            return airports.getFlights().entrySet().stream()
                    .filter(n -> n.getKey().equals(departure))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toMap(Object::toString, v -> v));
        } else {
            throw new RouteNotFoundException();
        }
    }


    public boolean flightsToDestination(Flight flight, Map<String, List<String>> map)  {
        return map.entrySet().iterator().next().getValue().contains(flight.getArrivalAirport())
                && !flight.getDepartureAirport().equals(flight.getArrivalAirport());
    }


    public ListDto transferFlight(Flight flight){
        List<String>  list = airports.getFlights().entrySet().stream()
                .filter(n -> n.getKey().equals(flight.getDepartureAirport()))
                .flatMap(arrivalAirports -> arrivalAirports.getValue().stream())
                .collect(Collectors.toList());

        List<String>  list1 = airports.getFlights().entrySet().stream()
                .filter(n -> n.getKey().equals(flight.getArrivalAirport()))
                .flatMap(arrivalAirports -> arrivalAirports.getValue().stream())
                .collect(Collectors.toList());
    return  new ListDto(list,list1);
    }
}
