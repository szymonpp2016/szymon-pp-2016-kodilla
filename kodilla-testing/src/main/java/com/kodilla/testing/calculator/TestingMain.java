package com.kodilla.testing.calculator;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        System.out.println("Moduł 6.2. Czym jest Test Driven Development");
        System.out.println("Zadanie: Pierwszy test jednostkowy \n");

        Calculator calculator = new Calculator();

        int addResult = calculator.add(200,100);
        int subResult = calculator.substract(200,100);

        if (addResult==300){
            System.out.println("Add test OK");
        } else {
            System.out.println("Add Error!");
        }
        if (subResult==100){
            System.out.println("Substract test OK");
        } else {
            System.out.println("Substract Error!");
        }
        System.out.println("\n Test jednostkowy clasy calculator zakończony");
    }
}
