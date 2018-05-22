package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuCell {

    private  int value;
    public static int EMPTY = -1;  //to jest przygotowanie do rozwiazania - gdzie -1 oznacza brak warości -zamiast kasowania z tablicy
    List<Integer> possibleValues= new ArrayList<>();

    public void resetPossibleValoues() {
        possibleValues.clear();
        Collections.addAll(possibleValues, 1, 2, 3, 4,5,6,7,8,9);
    }

    public void removeValue(Integer valoue){
        possibleValues.remove(valoue);
    }
}
