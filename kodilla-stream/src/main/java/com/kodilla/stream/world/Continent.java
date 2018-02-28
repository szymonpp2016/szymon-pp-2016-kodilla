package com.kodilla.stream.world;

import java.util.*;
import java.util.stream.Collectors;

public class Continent {

    private Country country;
    private Set<Country> continent = new HashSet<>();

    public void addCountry(Country country) {
        this.country=country;
        continent.add(country);
    }

    public Set<Double> getContinentPopulation(){
        return continent.stream()
                .map(Country::getCountryPopulation)
                .collect(Collectors.toSet());
    }
}
