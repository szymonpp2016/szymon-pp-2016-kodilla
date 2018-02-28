package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airports {

    public HashMap <String,Boolean> prepareFlightSchedule() {
        HashMap<String, Boolean>flightSchedule = new HashMap<>();
        flightSchedule.put("WARSAW",true);
        flightSchedule.put("CHRISTCHURCH",true);
        flightSchedule.put("PORTO",true);
        flightSchedule.put("PEKIN",true);
        return flightSchedule;
    }

    private List<String> getFlightsFromPorto() {
        List<String> airports = new ArrayList<>();
        airports.add("WARSAW");
        return airports;
    }

    private List<String> getFlightsFromPekin() {
        List<String> airports = new ArrayList<>();
        airports.add("CHRISTCHURCH");
        airports.add("WARSAW");
        return airports;
    }

    private List<String> getFlightsFromWarsaw() {
        List<String> airports = new ArrayList<>();
        airports.add("PORTO");
        airports.add("PEKIN");
        return airports;
    }

    private List<String> getFlightsFromChristchurch() {
        List<String> airports = new ArrayList<>();
        airports.add("PEKIN");
        return airports;
    }

    public final Map<String, List<String>> getFlights() {

        final Map<String, List<String>> flights = new HashMap<>();

        List<String> flightsFromPorto = getFlightsFromPorto();
        List<String> flightsFromPekin = getFlightsFromPekin();
        List<String> flightsFromWarsaw = getFlightsFromWarsaw();
        List<String> flightsFromChristchurch = getFlightsFromChristchurch();

        flights.put("PORTO", flightsFromPorto);
        flights.put("PEKIN", flightsFromPekin);
        flights.put("WARSAW", flightsFromWarsaw);
        flights.put("CHRISTCHURCH",flightsFromChristchurch );
        return flights;
    }
}
