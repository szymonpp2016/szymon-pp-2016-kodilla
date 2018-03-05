package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final String roll;
    private final Integer burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {

        private String roll;
        private String sauce;
        private Integer burgers;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {

            this.roll = roll;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(Integer burgers) {
            this.burgers= burgers;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    private Bigmac(final String roll,final Integer burgers, final String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers=burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getRoll() {
        return roll;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getBurgers() {
        return burgers;
    }

    @Override
    public String toString() {
        return "BigMac [" +
                "bottom='" + roll + '\'' +
                ", sauce='" + sauce + '\'' +
                ", number of burgers='" + burgers + '\'' +
                ", ingredients=" + ingredients +
                ']';
    }
}