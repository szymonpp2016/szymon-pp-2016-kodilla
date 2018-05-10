package com.kodilla.sudoku;

import org.apache.commons.lang3.Range;

public class SudokuValidateInputNumber {

    public void validateInputNumber(int x, int y, int  cellNumber) {
        final Range<Integer> between = Range.between(1, 10);

        if (between.contains(x)&&between.contains(y)&&between.contains(cellNumber)) {
            System.out.println("Input value correct!!");
        } else {
            throw new IllegalStateException("Bad number input!!!");
        }
    }
}