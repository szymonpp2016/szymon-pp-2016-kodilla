package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    private SudokuDisplayMessage sudokuDisplayMessage = new SudokuDisplayMessage();
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuBoardDrawer sudokuBoardDrawer = new SudokuBoardDrawer();
    private SudokuProcess sudokuProcess = new SudokuProcess();
    private Scanner scanner = new Scanner(System.in);
    private SudokuResolverAdvance sudokuResolverAdvance = new SudokuResolverAdvance(sudokuProcess,sudokuBoard,sudokuBoardDrawer);
    private int[][] board = new int[10][10];

    SudokuGame() {
        sudokuDisplayMessage.welcome();
        sudokuDisplayMessage.rule();
    }

    public boolean resolveSudoku() {
        int xAxiesCoordinate,yAxiesCoordinate,cellNumber;

        sudokuBoardDrawer.drawingSudokuTable(sudokuBoard);
        sudokuDisplayMessage.nextRoundAsk();
        String nextRoundAsk = scanner.next();

        if( sudokuProcess.testNextRonudAnswer(nextRoundAsk))
        {
            sudokuDisplayMessage.giveYourCellAnswer();

            xAxiesCoordinate = Integer.parseInt( scanner.next());
            yAxiesCoordinate = Integer.parseInt(scanner.next());
            cellNumber = Integer.parseInt(scanner.next());

            sudokuDisplayMessage.yourAnswerIS(xAxiesCoordinate, yAxiesCoordinate, cellNumber);
            sudokuProcess.askForCellNumber(xAxiesCoordinate,yAxiesCoordinate,cellNumber, sudokuBoard);
            sudokuDisplayMessage.nextRound();
            return false;
        }
        else{
            sudokuResolverAdvance.findSudokuAnswer(board);
            return true;
        }
    }
}
