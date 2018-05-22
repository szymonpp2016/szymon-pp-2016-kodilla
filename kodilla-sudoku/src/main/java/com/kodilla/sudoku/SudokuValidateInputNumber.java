package com.kodilla.sudoku;

import org.apache.commons.lang3.Range;

public class SudokuValidateInputNumber {

    public void validateInputNumber(int columnNumber, int rowNumber, int  cellValoue) {
        final Range<Integer> between = Range.between(1, 10);

        if (between.contains(columnNumber)&&between.contains(rowNumber)&&between.contains(cellValoue)) {
            System.out.println("Input value correct!!");
        } else {
            System.out.println("Bad number input!!!");
        }
    }
}