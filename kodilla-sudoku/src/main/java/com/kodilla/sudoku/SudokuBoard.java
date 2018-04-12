package com.kodilla.sudoku;

public class SudokuBoard {

    private SudokuPrepareBoard sudokuPrepareBoard =new SudokuPrepareBoard();
    public final static int MIN_INDEX = 1;
    public final static int MAX_INDEX = 9;
    int[][] board = new int[10][10];

    SudokuBoard() {
    }

    public int[][]  getSudokuNumber() {
        return board;
    }

    public void setSudokuNumber(int sudokuCellNumber, int x, int y) {
        board[x][y] = sudokuCellNumber;
    }

    public String drawingTableWithToStringRowResult() {
        String result = "\n";
        for(int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            if(n==1) sudokuPrepareBoard.rowNumberDrawer();
            if(n==1) result+=sudokuPrepareBoard.edgeLineDrawer()+"\n";
            result += n+ " |";
            for(int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if(board[k][n] == 0) {
                    result += " . ";
                } else {
                 result += " "+board[k][n]+" ";
                }
                if(k%3==0) result += "|";
            }
            result += "\n";
            if(n%3==0) result+=sudokuPrepareBoard.edgeLineDrawer()+ "\n";;
        }
        System.out.println(result);
        return result;
    }
}
