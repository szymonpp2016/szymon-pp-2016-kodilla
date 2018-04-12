package com.kodilla.sudoku;



public class SudokuResolverOld {
    public final static int MIN_INDEX = 1;
    public final static int MAX_INDEX = 9;
    private SudokuProcess sudokuProcess = new SudokuProcess();
    //SudokuElement sudokuElement = new SudokuElement();
    private SudokuBoard sudokuBoard = new SudokuBoard();

    public void findSudokuAnswer(int[][] board) {

        int tempNumberofPrevieCell=0;
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[k][n] == 0) {
                    boolean aceptableAnswer = false;
                    int cellNumber = 0;

                    while (!aceptableAnswer) {
                        cellNumber ++;
                        if(cellNumber==tempNumberofPrevieCell) cellNumber++;
                        board = sudokuBoard.getSudokuNumber();
                        aceptableAnswer = sudokuProcess.testGoodInput(board, k, n, cellNumber);

                        if (cellNumber > 9) {
                            cellNumber = 0;
                            aceptableAnswer = true;
                        }
                    }
                    sudokuBoard.setSudokuNumber(cellNumber, k, n);
                }
            }
        }
        sudokuBoard.drawingTableWithToStringRowResult();
    }
}
