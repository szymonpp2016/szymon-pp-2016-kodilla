package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Country {

    private final String countryName;
    private final Double countryPopulation;


    public Country(final String countryName, final Double countryPopulation) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
    }

    public String getCountryName() {
        return countryName;
    }

    public Double getCountryPopulation() {
        return countryPopulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryPopulation == country.countryPopulation &&
                Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryName, countryPopulation);
    }
}

