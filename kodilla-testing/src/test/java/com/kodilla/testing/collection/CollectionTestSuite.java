package com.kodilla.testing.collection;

import org.junit.*;

import com.kodilla.testing.collection.OddNumbersExterminator;
import java.util.*;
import java.lang.*;
import java.io.*;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
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
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> number = new ArrayList<Integer>();
        number.add(1);
        number.add(7);
        number.add(8);
        number.add(9);
        number.add(10);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator(number);
        //When
        ArrayList<Integer> result1 = oddNumbersExterminator.exterminate(number);
        System.out.println("Testing Normal List " + result1);
        //Then
        boolean oddFound = false;
        for (int n = 0; n < result1.size(); n++) {
            if (result1.get(n) % 2 != 0) {
                oddFound = true;
            }
        }
        Assert.assertFalse(oddFound);
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> number = new ArrayList<Integer>();

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator(number);

        //When
        ArrayList<Integer> result2 = oddNumbersExterminator.exterminate(number);
        System.out.println("Testing void list" + result2);
        //Then
        boolean evenFound = false;
        for (int n = 0; n < result2.size(); n++) {
            if (result2.get(n) % 2 != 0) {
                evenFound = true;
            }
        }
        Assert.assertFalse(evenFound);
    }
}
