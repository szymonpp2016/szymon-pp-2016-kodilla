package com.kodilla.sudoku;

import java.util.stream.IntStream;


public class SudokuProcess {
    private SudokuValidateInputNumber sudokuValidateInputNumber = new SudokuValidateInputNumber();

    private Boolean validateIfInCurrentCellIsAlreadyNumber;
    private Boolean validateColumnTest;
    private Boolean validateRowTest;
    private Boolean validateCurrentPoleTest;


    public boolean testGoodInput(int[][] board, int x, int y, int cellNumber) {
        validateIfInCurrentCellIsAlreadyNumber = true;
        validateColumnTest = true;
        validateRowTest = true;
        validateCurrentPoleTest = true;

        if (board[x][y] > 0) validateIfInCurrentCellIsAlreadyNumber = false;
        IntStream.range(1, 9).forEach(i -> {
            if (board[i][y] == cellNumber) validateColumnTest = false;
        });
                IntStream.range(1, 9).forEach(i -> {
            if (board[x][i] == cellNumber) validateRowTest = false;
        });

        int xStartCheckPole = chooseRightXYStartToChackPole(x, y).getX();
        int yStartCheckPole = chooseRightXYStartToChackPole(x, y).getY();

        IntStream.range(xStartCheckPole, xStartCheckPole + 2).forEach(i -> {
            if (board[i][yStartCheckPole] == cellNumber) validateCurrentPoleTest = false;
        });
        IntStream.range(xStartCheckPole, xStartCheckPole + 2).forEach(i -> {
            if (board[i][yStartCheckPole + 1] == cellNumber) validateCurrentPoleTest = false;
        });
        IntStream.range(xStartCheckPole, xStartCheckPole + 2).forEach(i -> {
            if (board[i][yStartCheckPole + 2] == cellNumber) validateCurrentPoleTest = false;
        });
       // System.out.println(validateIfInCurrentCellIsAlreadyNumber + "" + validateColumnTest + validateRowTest + validateCurrentPoleTest);
        return validateIfInCurrentCellIsAlreadyNumber && validateColumnTest && validateRowTest && validateCurrentPoleTest;
    }

    private SudokuCoordinateXyDto chooseRightXYStartToChackPole(int x, int y) {
        int x1 = ((x - 1) / 3) * 3 + 1;
        if (x < 3) x1 = 1;
        int y1 = ((y - 1) / 3) * 3 + 1;
        if (y < 3) y1 = 1;
        return new SudokuCoordinateXyDto(x1, y1);
    }

    public boolean testNextRonudAnswer(String nextRoundAsk) {
        {
            return nextRoundAsk.toUpperCase().equals("Y");
        }
    }

    public void askForCellNumber(int x, int y , int cellNumber, SudokuBoard sudokuBoard) {
        boolean aceptableAnswer=false;
        int[][] board;

        while(!aceptableAnswer) {
            sudokuValidateInputNumber.validateInputNumber(x,y, cellNumber);
            board = sudokuBoard.getSudokuArray();
            aceptableAnswer=testGoodInput(board, x, y, cellNumber);
        }
        sudokuBoard.setSudokuArray(cellNumber, x, y);
    }
}