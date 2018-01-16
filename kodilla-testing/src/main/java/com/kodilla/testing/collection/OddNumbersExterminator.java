package com.kodilla.testing.collection;

import java.util.*;
import java.lang.*;

public class OddNumbersExterminator {

    private ArrayList<Integer> numbers;

    public OddNumbersExterminator(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                evenNumbers.add(numbers.get(i));
            }
        }
        return evenNumbers;
    }
}

