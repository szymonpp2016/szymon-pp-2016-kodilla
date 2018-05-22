package com.kodilla.sudoku;

public class SudokuCoordinateXyDto {

    private int xColumnCoordinate;
    private int yRowCoordinate;
    SudokuCoordinateXyDto(int xColumn, int yRow) {
        this.xColumnCoordinate =xColumn;
        this.yRowCoordinate =yRow;
    }

    public int getXcolumn() {
        return xColumnCoordinate;
    }

    public int getYrow() {
        return yRowCoordinate;
    }
}
