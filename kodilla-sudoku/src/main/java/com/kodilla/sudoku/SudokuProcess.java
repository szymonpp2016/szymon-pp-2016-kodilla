package com.kodilla.sudoku;

import java.util.stream.IntStream;

public class SudokuProcess {
    private SudokuValidateInputNumber sudokuValidateInputNumber = new SudokuValidateInputNumber();
    private Boolean validateIfInCurrentCellIsAlreadyNumber;
    private Boolean validateColumnTest;
    private Boolean validateRowTest;
    private Boolean validateCurrentPoleTest;
    private int[][] board;

    public boolean validateInputNumber(int[][] board, int xColumn, int yRow, int cellValoue) {
        this.board=board;
        validateIfInCurrentCellIsAlreadyNumber = true;
        validateColumnTest = true;
        validateRowTest = true;
        validateCurrentPoleTest = true;
        if (board[xColumn][yRow] > 0) validateIfInCurrentCellIsAlreadyNumber = false;
        validateColumnAndRow(yRow, xColumn, cellValoue);
        validateCurrentCell(yRow, xColumn, cellValoue);
        return validateIfInCurrentCellIsAlreadyNumber && validateColumnTest && validateRowTest && validateCurrentPoleTest;
    }

    private SudokuCoordinateXyDto chooseRightXYStartToChackPole(int xColumnCoordinate, int yRowCoordinate) {
        int xColumnCoordinate1 = ((xColumnCoordinate - 1) / 3) * 3 + 1;
        if (xColumnCoordinate < 3) xColumnCoordinate1 = 1;
        int yRowCoordinate1 = ((yRowCoordinate - 1) / 3) * 3 + 1;
        if (yRowCoordinate < 3) yRowCoordinate1 = 1;
        return new SudokuCoordinateXyDto(xColumnCoordinate1, yRowCoordinate1);
    }

    public boolean testNextRonudAnswer(String nextRoundAsk) {
        {
            return nextRoundAsk.toUpperCase().equals("Y");
        }
    }

    public void askForCellNumber(int x, int y , int cellNumber, SudokuBoard sudokuBoard) {
        boolean aceptableAnswer=false;
        while(!aceptableAnswer) {
            sudokuValidateInputNumber.validateInputNumber(x,y, cellNumber);
            board = sudokuBoard.getSudokuArray();
            aceptableAnswer= validateInputNumber(board, x, y, cellNumber);
        }
        sudokuBoard.setSudokuArray(cellNumber, x, y);
    }

    private void validateColumnAndRow(int yRow, int xColumn, int cellValoue)
    {
        IntStream.range(1, 9).forEach(i -> {
            if (board[i][yRow] == cellValoue) validateColumnTest = false;});
        IntStream.range(1, 9).forEach(i -> {
            if (board[xColumn][i] == cellValoue) validateRowTest = false;});
    }

    private void validateCurrentCell(int yRow, int xColumn, int cellValoue) {
        int xStartCheckPole = chooseRightXYStartToChackPole(xColumn, yRow).getXcolumn();
        int yStartCheckPole = chooseRightXYStartToChackPole(xColumn, yRow).getYrow();

        IntStream.range(xStartCheckPole, xStartCheckPole + 2).forEach(i -> {
            if (board[i][yStartCheckPole] == cellValoue) validateCurrentPoleTest = false;});
        IntStream.range(xStartCheckPole, xStartCheckPole + 2).forEach(i -> {
            if (board[i][yStartCheckPole + 1] == cellValoue) validateCurrentPoleTest = false;});
        IntStream.range(xStartCheckPole, xStartCheckPole + 2).forEach(i -> {
            if (board[i][yStartCheckPole + 2] == cellValoue) validateCurrentPoleTest = false;});
    }
}
