package com.kodilla.sudoku;

import java.util.concurrent.ThreadLocalRandom;

public class SudokuResolverAdvance {  //ta klasa  prawdopodbnie do zmiany
    // za dużo odwołań do innych klas - ale na razie tak zostawiam
    private final static int MIN_INDEX = 1;
    private final static int MAX_INDEX = 9;
    private SudokuCell sudokuCell = new SudokuCell();

    private SudokuProcess sudokuProcess;
    private SudokuBoard sudokuBoard;
    private SudokuBoardDrawer sudokuBoardDrawer;
    private boolean acceptableAnswer = false;
    private Integer cellValue = 0;

    private void setAcceptableAnswer(boolean acceptableAnswer) {
        this.acceptableAnswer = acceptableAnswer;
    }

    private void setCellValue(Integer cellValue) {
        this.cellValue = cellValue;
    }

    SudokuResolverAdvance(SudokuProcess sudokuProcess, SudokuBoard sudokuBoard,
                          SudokuBoardDrawer sudokuBoardDrawer) {
        this.sudokuProcess = sudokuProcess;
        this.sudokuBoard = sudokuBoard;
        this.sudokuBoardDrawer = sudokuBoardDrawer;
    }

    public void findSudokuAnswer(int[][] board) {
        for (int row = MIN_INDEX; row <= MAX_INDEX; row++) {
            for (int column = MIN_INDEX; column <= MAX_INDEX; column++) {
                nullCellValueChecker(column, row, board);
                sudokuCell.resetPossibleValoues();
                cellValueFindPorcess(column,row, board);
                sudokuBoard.setSudokuArray(cellValue, column, row);
            }
        }
        sudokuBoardDrawer.drawingSudokuTable(sudokuBoard);
    }

    private void exitAfterItaratingAllCellsOrPossibleNumbers(int cellValue, boolean acceptableAnswer) {
        if (sudokuCell.possibleValues.size() < 1 || cellValue > 9) {
            setCellValue(0);
            setAcceptableAnswer(true);
            sudokuCell.resetPossibleValoues();
        }
    }

    private void removeValueWithCantBeInTheCurrentCell(int cellValue) {
        if (sudokuCell.possibleValues.contains(cellValue)) {
            try {
                sudokuCell.removeValue(cellValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void nullCellValueChecker(int column, int row, int[][] board) {
        if (board[column][row] == 0) {
            setAcceptableAnswer(false);
            setCellValue(0);
        }
    }

    private void cellValueFindPorcess(int column, int row, int[][] board) {
        while (!acceptableAnswer) {
            cellValue = ThreadLocalRandom.current().nextInt(MIN_INDEX, MAX_INDEX + 1);
            removeValueWithCantBeInTheCurrentCell(cellValue);
            board = sudokuBoard.getSudokuArray();
            acceptableAnswer = sudokuProcess.validateInputNumber(board, column, row, cellValue);
            exitAfterItaratingAllCellsOrPossibleNumbers(cellValue, acceptableAnswer);
        }
    }
}