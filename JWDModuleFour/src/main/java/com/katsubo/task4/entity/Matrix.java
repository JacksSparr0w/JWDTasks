package com.katsubo.task4.entity;

public class Matrix {
    Element[][] elements;

    public Matrix(Element[][] elements) {
        this.elements = elements;
    }

    public void setElement(int row, int col, int value) {
        elements[row][col].setValue(value);
    }

    @Override
    public String toString() {
        StringBuilder rezult = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                rezult.append(elements[i][j].toString() + " ");
            }
            rezult.append("\n");
        }
        return rezult.toString();
    }

    public int getSize() {
        return elements.length;
    }

    public int getElementValue(int row, int col) {
        return elements[row][col].getValue();
    }
}
