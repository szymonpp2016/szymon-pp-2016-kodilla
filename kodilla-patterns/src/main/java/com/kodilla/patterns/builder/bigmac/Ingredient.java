package com.kodilla.patterns.builder.bigmac;

final public class Ingredient {
    final static String SALAD = "SALAD";
    final static String ONION = "ONION";
    final static String BACON = "BACON";
    final static String CHEESE = "CHEESE";
    final static String CUCUMBERS = "CUCUMBERS";
    final static String CHILIPEPPERS = "CHILI PEPPERS";
    final static String CHAMPIGNONS = "CHAMPIGNONS";
    final static String SHRIMPS = "SHRIMPS";

    private Ingredient() {
    }

   /* public Ingredient1(String ingredient) {
        if (ingredient.equals(SALAD) ||
                ingredient.equals(ONION) ||
                ingredient.equals(BACON) ||
                ingredient.equals(CHEESE)) ||
                ingredient.equals(CUCUMBERS) ||
                ingredient.equals(CHILIPEPPERS) ||
                ingredient.equals(CHAMPIGNONS) ||
                ingredient.equals(SHRIMPS)
                {
            this.ingredient = ingredient;
        } else {
            throw new IllegalStateException("Select  ingredients: " +
                    "SALAD, ONION, BACON, CUCUMBERS, CHILI PEPPERS, CHAMPIGNONS, SHRIMPS, CHEESE");
        }
    }

    @Override
    public String toString() {
        return ingredient;
    } */
}

