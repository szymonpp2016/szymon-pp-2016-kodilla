package com.kodilla.sudoku;

public class SudokuCellNumber {

    private String sudokuCellNumber;
    private int number;


    SudokuCellNumber() {
        if (number<10 ) {
            this.sudokuCellNumber =  java.lang.Integer.toString( number);
        } else {
            throw new IllegalStateException("Bad number add!");
        }
    }

    public String getNumber() {
        return sudokuCellNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}