package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuBoardDrawer sudokuBoardDrawer = new SudokuBoardDrawer();
    private SudokuProcess sudokuProcess = new SudokuProcess();
    private Scanner scanner = new Scanner(System.in);
    private SudokuResolverAdvance sudokuResolverAdvance = new SudokuResolverAdvance(sudokuProcess,sudokuBoard,sudokuBoardDrawer);

    private int[][] board = new int[10][10];

    public boolean resolveSudoku() {
        int xColumnCoordinate,yRowCoordinate,cellValue;

        sudokuBoardDrawer.drawingSudokuTable(sudokuBoard);
        SudokuDisplayMessage.nextRoundAsk();
        String nextRoundAsk = scanner.next();

        if( sudokuProcess.testNextRonudAnswer(nextRoundAsk))
        {
            SudokuDisplayMessage.giveYourCellAnswer();

            xColumnCoordinate = Integer.parseInt( scanner.next());
            yRowCoordinate = Integer.parseInt(scanner.next());
            cellValue = Integer.parseInt(scanner.next());

            SudokuDisplayMessage.yourAnswerIS(xColumnCoordinate, yRowCoordinate, cellValue);
            sudokuProcess.askForCellNumber(xColumnCoordinate,yRowCoordinate,cellValue, sudokuBoard);
            SudokuDisplayMessage.nextRound();
            return false;
        }
        else{
            sudokuResolverAdvance.findSudokuAnswer(board);
            return true;
        }
    }
}
