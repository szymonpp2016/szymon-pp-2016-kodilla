package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testPizzaNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Ingredient.SALAD)
                .burgers(2)
                .roll(Roll.WITHOUTSEZAM)
                .sauce(Sauce.BARBECUE)
                .ingredient(Ingredient.ONION)
                .ingredient(Ingredient.CHILIPEPPERS)
                .ingredient(Ingredient.BACON)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(4, howManyIngredients);
    }
}

