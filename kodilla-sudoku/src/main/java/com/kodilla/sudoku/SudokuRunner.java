package com.kodilla.sudoku;

public class SudokuRunner {
    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuGame SudokuGame = new SudokuGame();

        while(!gameFinished) {
        gameFinished = SudokuGame.resolveSudoku();
        }
    }
}
