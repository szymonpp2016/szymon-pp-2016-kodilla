package com.kodilla.sudoku;

public class SudokuCoordinateXyDto {

    private int xAxiesCoordinate;
    private int yAxiesCoordinate;
    SudokuCoordinateXyDto(int x, int y) {
        this.xAxiesCoordinate =x;
        this.yAxiesCoordinate =y;
    }

    public int getX() {
        return xAxiesCoordinate;
    }

    public int getY() {
        return yAxiesCoordinate;
    }
}
