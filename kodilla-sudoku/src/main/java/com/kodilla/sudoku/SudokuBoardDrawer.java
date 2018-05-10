package com.kodilla.sudoku;

import java.util.stream.IntStream;

public class SudokuBoardDrawer {

    private final static int MIN_INDEX = 1;
    private final static int MAX_INDEX = 9;

    public void drawingSudokuTable(SudokuBoard sudokuBoard) {
        int[][] board=sudokuBoard.getSudokuArray();

        StringBuilder TableHolderAsString = new StringBuilder("\n");
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            if (n == 1) rowNumberDrawer();
            if (n == 1) TableHolderAsString.append(edgeLineDrawer()).append("\n");
            TableHolderAsString.append(n).append(" |");
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[k][n] == 0) {
                    TableHolderAsString.append(" . ");
                } else {
                    TableHolderAsString.append(" ").append(board[k][n]).append(" ");
                }
                if (k % 3 == 0) TableHolderAsString.append("|");
            }
            TableHolderAsString.append("\n");
            if (n % 3 == 0) TableHolderAsString.append(edgeLineDrawer()).append("\n");
        }
        System.out.println(TableHolderAsString);
    }

    private void rowNumberDrawer() {
        System.out.print("  ");
        IntStream.range(1,10)
                .forEach(n-> {
                    System.out.print("  "+ n);
                    if(n%3==0) System.out.print(" ");
                });
    }

    private String edgeLineDrawer() {
        final String[] result = {"  "};
        System.out.print("    ");
        IntStream.range(0,3)
                .forEach(n-> result[0] +="| -  -  - ");
        return result[0];
    }
}

