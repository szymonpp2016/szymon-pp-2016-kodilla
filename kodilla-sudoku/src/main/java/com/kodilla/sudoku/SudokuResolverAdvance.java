package com.kodilla.sudoku;

import java.util.concurrent.ThreadLocalRandom;

public class SudokuResolverAdvance {  //ta klasa  prawdopodbnie do zmiany za dużo odwołań do innych klas - ale na razie tak zostawiam
    private final static int MIN_INDEX = 1;
    private final static int MAX_INDEX = 9;
    private SudokuElement sudokuElement =new SudokuElement();

    private SudokuProcess sudokuProcess;
    private SudokuBoard sudokuBoard;
    private SudokuBoardDrawer sudokuBoardDrawer;

    SudokuResolverAdvance(SudokuProcess sudokuProcess, SudokuBoard sudokuBoard, SudokuBoardDrawer sudokuBoardDrawer) {
        this.sudokuProcess = sudokuProcess;
        this.sudokuBoard = sudokuBoard;
        this.sudokuBoardDrawer = sudokuBoardDrawer;
    }

    public void findSudokuAnswer(int[][] board) {

        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[k][n] == 0) {
                    boolean acceptableAnswer = false;
                    Integer cellNumber = 0;

                    sudokuElement.resetPossibleValoues();
                    while (!acceptableAnswer) {
                        cellNumber= ThreadLocalRandom.current().nextInt(1, 9 + 1);

                        if(sudokuElement.possibleValues.contains(cellNumber)) {
                            try {
                                sudokuElement.removeValue(cellNumber);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        board = sudokuBoard.getSudokuArray();
                        acceptableAnswer = sudokuProcess.testGoodInput(board, k, n, cellNumber);

                        if (sudokuElement.possibleValues.size()<1||cellNumber>9) {
                            cellNumber = 0;
                            acceptableAnswer = true;
                            sudokuElement.resetPossibleValoues();
                        }
                    }
                    sudokuBoard.setSudokuArray(cellNumber, k, n);
                }
            }
        }
        sudokuBoardDrawer.drawingSudokuTable(sudokuBoard);
    }
}
