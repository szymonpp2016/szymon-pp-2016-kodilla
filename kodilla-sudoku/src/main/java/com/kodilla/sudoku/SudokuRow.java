package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    public List<SudokuElement> rowValues;

    public SudokuRow() {

        rowValues = new ArrayList<>(9);
    }
}
