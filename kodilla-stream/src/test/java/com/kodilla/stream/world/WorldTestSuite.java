package com.kodilla.stream.world;

import org.junit.*;

import java.math.BigDecimal;

public class WorldTestSuite {
    private static int testCounter = 0;

    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country country0 = new Country("Spain", 48000000.0);
        Country country1 = new Country("Poland", 35000000.0);
        Country country2 = new Country("Mexico", 127000000.0);
        Country country3 = new Country("Japan", 127000000.0);
        Country country4 = new Country("Canada", 36000000.0);
        Country country5 = new Country("China", 1300000000.0);
        Country country6 = new Country("Brazil", 207000000.0);



        BigDecimal worldPopulation;
        worldPopulation = BigDecimal.valueOf(
                (country1.getCountryPopulation() + country2.getCountryPopulation() +
                        country3.getCountryPopulation() + country4.getCountryPopulation() +
                        country5.getCountryPopulation() + country6.getCountryPopulation()+
                        country0.getCountryPopulation()));


        Continent europe = new Continent();
        Continent asia = new Continent();
        Continent americas = new Continent();
        World world = new World();

        //When
        europe.addCountry(country0);
        europe.addCountry(country1);
        asia.addCountry(country3);
        asia.addCountry(country5);
        americas.addCountry(country2);
        americas.addCountry(country4);
        americas.addCountry(country6);

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(americas);

        //Then
        Assert.assertEquals(worldPopulation.setScale(0), world.getPeopleQuantity());

    }
}

