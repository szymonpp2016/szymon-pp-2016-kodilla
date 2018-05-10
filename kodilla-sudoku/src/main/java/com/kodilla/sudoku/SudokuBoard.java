package com.kodilla.sudoku;

public class SudokuBoard {

    private int[][] board = new int[10][10];

    public int[][] getSudokuArray() {
        return board;
    }

    public void setSudokuArray(int sudokuCellNumber, int xAxiesCoordinate, int yAxiesCoordinate) {
        board[xAxiesCoordinate][yAxiesCoordinate] = sudokuCellNumber;
    }
}
