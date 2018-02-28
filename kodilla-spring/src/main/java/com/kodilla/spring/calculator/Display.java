package com.kodilla.spring.calculator;


import org.springframework.stereotype.Component;

@Component
public class Display {

    double displayValue(double val) {
        System.out.println("Dispaly valoue: "+val);
        return val;
    }
}
