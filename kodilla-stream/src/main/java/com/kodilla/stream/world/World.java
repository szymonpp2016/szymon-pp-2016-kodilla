package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class World {

    private  Set<Continent> continents = new HashSet<>();

    public void addContinent(Continent continent) {
        this.continents = continents;
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continentPopulation -> continentPopulation.getContinentPopulation().stream())
                .map(BigDecimal::valueOf)  //potrzeba wytłumaczenia jak to działa
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

    }



}

