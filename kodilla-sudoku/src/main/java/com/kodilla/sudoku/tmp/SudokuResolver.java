package com.kodilla.sudoku.tmp;


import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuProcess;

public class SudokuResolver {
  /*  public final static int MIN_INDEX = 1;
    public final static int MAX_INDEX = 9;
    private SudokuProcess sudokuProcess = new SudokuProcess();
    //SudokuElement sudokuElement = new SudokuElement();
    private SudokuBoard sudokuBoard = new SudokuBoard();

    public void findSudokuAnswer(int[][] board) {
        int wrongAnswer = 0;
        int tempNumberofPrevieCell=0;
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[k][n] == 0) {
                    boolean aceptableAnswer = false;
                    int cellNumber = 0;
                     wrongAnswer = 0;
                    while (!aceptableAnswer) {
                        cellNumber ++;
                        if(cellNumber==tempNumberofPrevieCell) cellNumber++;
                        wrongAnswer = 0;
                        board = sudokuBoard.getSudokuArray();
                        aceptableAnswer = sudokuProcess.testGoodInput(board, k, n, cellNumber);
                        System.out.println(n+" "+k+"  "+cellNumber+"  "+aceptableAnswer);
                        if (cellNumber > 9) {

                            cellNumber = 0;
                            aceptableAnswer = true;

                            wrongAnswer = 1;
                            System.out.println("n:" + n + "k:" + k);

                        }

                    }
                    if (wrongAnswer==0) sudokuBoard.setSudokuArray(cellNumber, k, n);
                    System.out.println(tempNumberofPrevieCell=board [k-1][n]);
                    if (wrongAnswer==1) sudokuBoard.setSudokuArray(0, k, n);
                    if (wrongAnswer==1) sudokuBoard.setSudokuArray(0, k-1, n);
                }
            if(wrongAnswer==1) System.out.println("bad");;
            if(wrongAnswer==1) k = k-2;
            if(wrongAnswer==1) if (k < 1) k = 1;
            }

        }
        sudokuBoard.drawingSudokuTable();
    } */
}
