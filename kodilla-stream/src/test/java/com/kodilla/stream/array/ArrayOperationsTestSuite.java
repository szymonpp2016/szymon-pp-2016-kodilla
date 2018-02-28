package com.kodilla.stream.array;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.Random;

public class ArrayOperationsTestSuite {
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
    public void testGetAverage() {

        //Given - wykorzystano zaadanie z modułu 2
        Random generator = new Random();  // obiekt jako generator liczb pseudolosowych - klasa "natywna"
        int n = 20;
        int sum = 0;
        int[] randomNumber = new int[n];
        System.out.println("\n Welcome to the number generator for Lotto");
        System.out.println("Your `happy number` for the following days: \n");

        for(int i=1; i<randomNumber.length; i++) {
            randomNumber[i] = generator.nextInt(n);
            System.out.println("The number per day (Array`s Value) No.:"+i+ " is: " + randomNumber[i]);
            sum += randomNumber[i];
        }
        System.out.println("(Hint: day 0 - means today, day 1 -  means tomorrow etc.)");
        System.out.printf("\n Average value (rounded up to two decimal places)): %.2f", (double)sum/randomNumber.length);

        //When
        Double avarge = ArrayOperations.getAverage(randomNumber);
        //Then
        assertEquals((double)sum/randomNumber.length , avarge, 0.1);
    }
}