package com.kodilla.patterns2.decorator.pizza;

import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {



    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Kodilla module 20.2 Decorator:  begin"); }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 20.2: end \n");
    }
    @Before
    public void before() {
        System.out.println("\n Preparing to execute test `Pizza DECORATOR' : \n " );
    }
    @After
    public void after() {
        System.out.println("\n End Test 'Pizza DECORATOR'  " );
    }



    @Test
    public void test1PizzaOrderGetCost() {
        // Given
        PizzaOrder pizzaOrder = new MainPizzaOrder();
        // When
        BigDecimal pizzaCost = pizzaOrder.getCost();
        //Then
        assertEquals(2, pizzaCost.intValue());
    }


    @Test
    public void test2PizzaWithAddOrderGetCost() {
        // Given
        PizzaOrder pizzaOrder = new MainPizzaOrder();
        pizzaOrder = new KindPizzaDecorator(pizzaOrder, KindPizzaDecorator.KindOfPizza.ITALIEN);
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder, CheeseOrderDecorator.Cheese.GOUDA);
        pizzaOrder = new SauceDecorator(pizzaOrder, SauceDecorator.Sauce.GARLIC);

        // When
        BigDecimal pizzaCost = pizzaOrder.getCost();
        System.out.println(pizzaOrder.getDescription());
        //Then
        assertEquals(14, pizzaCost.intValue());
    }

    @Test
    public void test3PizzaOrderGetName() {
        // Given
        PizzaOrder pizzaOrder = new MainPizzaOrder();
        pizzaOrder = new KindPizzaDecorator(pizzaOrder, KindPizzaDecorator.KindOfPizza.ITALIEN);
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder, CheeseOrderDecorator.Cheese.GOUDA);
        pizzaOrder = new SauceDecorator(pizzaOrder, SauceDecorator.Sauce.GARLIC);

        // When
        String pizzaDescryption = pizzaOrder.getDescription();
        System.out.println(pizzaOrder.getDescription());
        //Then
        assertEquals("You order: Orginal Italien pizza \n" +
                " - cheese: Gouda \n" +
                " - sauce: Garlic sauce", pizzaDescryption);
    }
}
