package com.kodilla.sudoku;

public class
SudokuApplicationRunner {
    public static void main(String[] args) {
        boolean gameFinished = false;

        SudokuDisplayMessage.welcome();
        SudokuDisplayMessage.rule();

        SudokuGame sudokuGame = new SudokuGame();
        while(!gameFinished) {
            gameFinished = sudokuGame.resolveSudoku();
        }
    }
}
