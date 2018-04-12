package com.kodilla.sudoku;

import java.util.stream.IntStream;


public class SudokuProcess {

    private Boolean validateCurrentCellTest;
    private Boolean validateColumnTest;
    private Boolean validateColumnTest1;
    private Boolean validateCurrentPoleTest;


    public boolean testGoodInput(int[][] board,int x , int y, int cellNumber){
        validateCurrentCellTest =true;
        validateColumnTest=true;
        validateColumnTest1=true;
        validateCurrentPoleTest =true;

        if(board[x][y]>0) validateCurrentCellTest =false;

        IntStream.range(1,9).forEach(i->{ if(board[i][y]==cellNumber) validateColumnTest =false;});

        IntStream.range(1,9).forEach(i->{ if(board[x][i]==cellNumber) validateColumnTest1 =false; });

       int xStartCheckPole= chooseRightXYStartToChackPole(x,y).getX();
       int yStartCheckPole= chooseRightXYStartToChackPole(x,y).getY();

       IntStream.range(xStartCheckPole,xStartCheckPole+2).forEach(i->{ if(board[i][yStartCheckPole]==cellNumber ) validateCurrentPoleTest =false;});
       IntStream.range(xStartCheckPole,xStartCheckPole+2).forEach(i->{ if(board[i][yStartCheckPole+1]==cellNumber ) validateCurrentPoleTest =false;});
       IntStream.range(xStartCheckPole,xStartCheckPole+2).forEach(i->{ if(board[i][yStartCheckPole+2]==cellNumber ) validateCurrentPoleTest =false;});

       System.out.println(validateCurrentCellTest +""+validateColumnTest+validateColumnTest1+ validateCurrentPoleTest);

    return validateCurrentCellTest &&validateColumnTest&&validateColumnTest1&& validateCurrentPoleTest;
    }


    public XyDto chooseRightXYStartToChackPole(int x, int y)
    {
        int x1= ((x-1)/3)*3+1;
        if(x<3) x1=1;

        int y1= ((y-1)/3)*3+1;
        if(y<3) y1=1;

        return new XyDto(x1,y1);}
    }
