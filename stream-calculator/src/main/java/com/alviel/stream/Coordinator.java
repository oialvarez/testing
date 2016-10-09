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
        totalElementsCounter++;
        Integer actualElementsSideSize = (int) Math.floor(Math.sqrt(totalElementsCounter));
        if (workingWithHorizontalCoordinate) {
            workWithHorizontal(actualElementsSideSize);
        } else {
            workWithVertical(actualElementsSideSize);
        }
    }

    private void workWithHorizontal(Integer actualElementsSideSize) {
        if (incrementHorizontal) {
            horizontalCoordinate++;
        } else {
            horizontalCoordinate--;
        }
        if (checkStopCondition(++horizontalCounter, actualElementsSideSize)) {
            workingWithHorizontalCoordinate = false;
            incrementHorizontal = !incrementHorizontal;
            horizontalCounter = 0;
        }
    }

    private boolean checkStopCondition(int counter, Integer sideSize) {
        return counter == sideSize;
    }

    private void workWithVertical(Integer actualElementsSideSize) {
        if (incrementVertical) {
            verticalCoordinate++;
        } else {
            verticalCoordinate--;
        }
        if (checkStopCondition(++verticalCounter, actualElementsSideSize)) {
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
