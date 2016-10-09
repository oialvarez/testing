package com.alviel.stream;

/**
 * @author Oscar Alvarez
 * @since 9/24/16
 */
public class Coordinator {
    private int totalElementsCounter;
    private boolean workingWithHorizontalCoordinate;
    private boolean incrementVertical;
    private boolean incrementHorizontal;
    private int verticalCoordinate;
    private int horizontalCoordinate;
    private int verticalCounter;
    private int horizontalCounter;

    public Coordinator(int matrixSide) {
        Integer center = (int) Math.floor(matrixSide / 2.0);
        verticalCoordinate = center;
        horizontalCoordinate = center - 1;
        if (matrixSideIsOdd(matrixSide)) {
            horizontalCoordinate = center;
        }
        totalElementsCounter = 1;
        workingWithHorizontalCoordinate = true;
        incrementVertical = false;
        incrementHorizontal = true;
    }

    private boolean matrixSideIsOdd(int matrixSide) {
        return (matrixSide % 2) == 1;
    }

    public void coordinateNextCoordinates() {
        if (workingWithHorizontalCoordinate) {
            workWithHorizontal();
        } else {
            workWithVertical();
        }
    }

    private void workWithHorizontal() {
        if (incrementHorizontal) {
            horizontalCoordinate++;
        } else {
            horizontalCoordinate--;
        }
        if (checkStopCondition(++horizontalCounter)) {
            workingWithHorizontalCoordinate = false;
            incrementHorizontal = !incrementHorizontal;
            horizontalCounter = 0;
        }
    }

    private boolean checkStopCondition(int counter) {
        totalElementsCounter++;
        Integer actualElementsSideSize = (int) Math.floor(Math.sqrt(totalElementsCounter));
        return counter == actualElementsSideSize;
    }

    private void workWithVertical() {
        if (incrementVertical) {
            verticalCoordinate++;
        } else {
            verticalCoordinate--;
        }
        if (checkStopCondition(++verticalCounter)) {
            workingWithHorizontalCoordinate = true;
            incrementVertical = !incrementVertical;
            verticalCounter = 0;
        }
    }

    public Integer getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public Integer getVerticalCoordinate() {
        return verticalCoordinate;
    }

}
