package com.kodilla.sudoku;

import java.util.stream.IntStream;

public class SudokuPrepareBoard {

    private String  result=null;

    public void rowNumberDrawer() {
        System.out.print("  ");
        IntStream.range(1,10)
                .forEach(n-> {
                    System.out.print("  "+ n);
                    if(n%3==0) System.out.print(" ");
                });
    }

    public String edgeLineDrawer( ) {
        final String[] result = {"  "};
        System.out.print("    ");
        IntStream.range(0,3)
                .forEach(n-> result[0] +="| -  -  - ");
        return result[0];
    }
}
