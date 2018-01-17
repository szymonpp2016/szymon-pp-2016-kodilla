package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    public ArrayList<Shape> figureList = new ArrayList<Shape>();
    public Shape figure;

    public void addFigure(Shape shape) {
        figureList.add(shape);
    }

    public boolean removeFigure(Shape shape) {

        figureList.remove(shape);
        if(figureList.contains(shape)) {
            return false;
        }
        else {
            return true;
        }
    }

    public Shape getFigure(int n) {
        figure = figureList.get(n);
        return figure;
    }
}
