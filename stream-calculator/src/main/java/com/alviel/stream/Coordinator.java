package com.alviel.stream;

/**
 * @author Oscar Alvarez
 * @since 9/24/16
 */
public class Coordinator {
    private boolean incrementVertical;
    private boolean incrementHorizontal;
    private boolean workingWithHorizontalCoordinate;
    private int verticalCoordinate;
    private int horizontalCoordinate;
    private int totalCount;
    private int horizontalCounter;
    private int verticalCounter;

    public Coordinator(int matrixSide) {
        Integer center = (int) Math.floor(matrixSide / 2.0);
        verticalCoordinate = center;
        horizontalCoordinate = center - 1;
        if (matrixSideIsOdd(matrixSide)) {
            horizontalCoordinate = center;
        }
        totalCount = 2;
        workingWithHorizontalCoordinate = true;
        incrementHorizontal = true;
        incrementVertical = false;
    }

    private boolean matrixSideIsOdd(int matrixSide) {
        return (matrixSide % 2) == 1;
    }

    public Integer getVerticalCoordinate() {
        return verticalCoordinate;
    }

    public Integer getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public void coordinateNextCoordinates() {
        totalCount++;
        Integer actualElementsSideSize = (int) Math.ceil(Math.sqrt(totalCount));
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
        horizontalCounter++;
        if ((horizontalCounter + 1) == actualElementsSideSize) {
            workingWithHorizontalCoordinate = false;
            incrementHorizontal = !incrementHorizontal;
            horizontalCounter = 0;
        }
    }

    private void workWithVertical(Integer actualElementsSideSize) {
        if (incrementVertical) {
            verticalCoordinate++;
        } else {
            verticalCoordinate--;
        }
        verticalCounter++;
        if ((verticalCounter + 1) == actualElementsSideSize) {
            workingWithHorizontalCoordinate = true;
            incrementVertical = !incrementVertical;
            verticalCounter = 0;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordinator{");
        sb.append("verticalCoordinate=").append(verticalCoordinate);
        sb.append(", horizontalCoordinate=").append(horizontalCoordinate);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", horizontalCounter=").append(horizontalCounter);
        sb.append(", verticalCounter=").append(verticalCounter);
        sb.append(", workingWithHorizontalCoordinate=").append(workingWithHorizontalCoordinate);
        sb.append('}');
        return sb.toString();
    }
}
