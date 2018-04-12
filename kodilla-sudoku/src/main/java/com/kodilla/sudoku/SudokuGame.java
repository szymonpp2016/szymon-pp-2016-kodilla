package com.kodilla.sudoku;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SudokuGame {

    private SudokuDisplayMessage sudokuDisplayMessage = new SudokuDisplayMessage();
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuCellNumber sudokuCellNumber = new SudokuCellNumber();
    private SudokuProcess sudokuProcess = new SudokuProcess();
    private Scanner scanner = new Scanner(System.in);
    private  SudokuResolver sudokuResolver = new SudokuResolver();
    private  SudokuResolverOld sudokuResolverOld = new SudokuResolverOld();

    int[][] board = new int[10][10];
    private int x;
    private int y ;
    private int cellNumber ;

    SudokuGame() {
        sudokuDisplayMessage.welcome();
        sudokuDisplayMessage.rule();
    }

    public boolean resolveSudoku() {
        sudokuBoard.drawingTableWithToStringRowResult();
        sudokuDisplayMessage.nextGameAsk();
        int end = scanner.nextInt();
        if (end == 1) {
        sudokuResolverOld.findSudokuAnswer(board);
            return true;
        }
        else {
            boolean aceptableAnswer=false;
            while(!aceptableAnswer) {
                sudokuDisplayMessage.giveYourCellAnswer();
                x = scanner.nextInt();
                y = scanner.nextInt();
                cellNumber = scanner.nextInt();
                sudokuCellNumber.setNumber(cellNumber);
                sudokuDisplayMessage.yourAnswerIS(x, y, cellNumber);
                board = sudokuBoard.getSudokuNumber();
                aceptableAnswer=sudokuProcess.testGoodInput(board, x, y, cellNumber);
            }
            sudokuBoard.setSudokuNumber(cellNumber, x, y);
            try {
                System.out.print(" \n next round!\n\n");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
