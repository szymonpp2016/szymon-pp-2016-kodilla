package com.kodilla.sudoku;

import java.util.stream.IntStream;

public class SudokuBoardDrawer {
    private final static int MIN_INDEX = 1;
    private final static int MAX_INDEX = 9;

    public void drawingSudokuTable(SudokuBoard sudokuBoard) {
        int[][] board=sudokuBoard.getSudokuArray();
        System.out.println(tableBuilde(board));
    }

    private StringBuilder tableBuilde(int[][] board) {
        StringBuilder tableHolderAsString = new StringBuilder("\n");
        for (int row = MIN_INDEX; row <= MAX_INDEX; row++) {
            if (row == 1) {
                rowNumberDrawer();
                tableHolderAsString.append(edgeLineDrawer()).append("\n");
            }
            tableHolderAsString.append(row).append(" |");
            rowBuilder(board,tableHolderAsString ,row );
            tableHolderAsString.append("\n");
            if (row % 3 == 0) tableHolderAsString.append(edgeLineDrawer()).append("\n");
        }
        return tableHolderAsString;
    }

    private StringBuilder rowBuilder(int[][] board,StringBuilder tableHolderAsString, int row ) {
        for (int column = MIN_INDEX; column <= MAX_INDEX; column++) {
            if (board[column][row] == 0) {
                tableHolderAsString.append(" . ");
            } else {
                tableHolderAsString.append(" ").append(board[column][row]).append(" ");
            }
            if (column % 3 == 0) tableHolderAsString.append("|");
        }
        return tableHolderAsString;
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

