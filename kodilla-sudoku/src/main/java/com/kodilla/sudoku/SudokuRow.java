package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {  //ta klasa  na razie jako zaczątek  do stworzenia tablicy wszystkich elementów - obecne klasa nie używana
    //chyba ze znajdziemy jakiś inny pomysł na to

    private List<SudokuCell> rowValues;

    public SudokuRow() {

        rowValues = new ArrayList<>(9);
    }
}
