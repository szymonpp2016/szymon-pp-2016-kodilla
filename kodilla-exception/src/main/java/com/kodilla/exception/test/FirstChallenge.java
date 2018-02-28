package com.kodilla.exception.test;

public class FirstChallenge {

    private double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result;
        try {
            result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch(ArithmeticException e) {
            System.out.println("Pamiętaj `cholero` nie dziel przez zero!!");
        }
        finally {
            System.out.println("Operacja zakończona ");
        }
    }
}