package com.alviel.stream;

/**
 * @author Oscar Alvarez
 * @since 9/23/16
 */
public class Caracol {
    private final String stream;

    private StringCalculator stringCalculator;

    public Caracol(String stream) {
        this.stream = stream;
    }

    public void setStringCalculator(StringCalculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }

    public String[][] reverseMatrix() {
        String[][] result = new String[1][1];

        if (stream == null || stream.length() == 0) {
            result[0][0] = "";
        } else if (stream.length() == 1) {
            result[0][0] = stream;
        } else {
            String[] split = getReversedArray();
            int matrixSide = getMatrixSize(split.length);
            result = getInitializedMatrix(matrixSide);
            Coordinator coordinator = new Coordinator(matrixSide);

            for (String s : split) {
                result[coordinator.getVerticalCoordinate()][coordinator.getHorizontalCoordinate()] = s;
                coordinator.coordinateNextCoordinates();
            }
        }

        return result;
    }

    private String[] getReversedArray() {
        String reverse = stringCalculator.reverse();
        return reverse.split(",");
    }

    private int getMatrixSize(int totalItems) {
        return (int) Math.ceil(Math.sqrt(totalItems));
    }

    private String[][] getInitializedMatrix(int matrixSide) {
        String[][] result;
        result = new String[matrixSide][matrixSide];
        for (int i = 0; i < matrixSide; i++) {
            for (int j = 0; j < matrixSide; j++) {
                result[i][j] = "";
            }
        }
        return result;
    }

    public void print(String[][] result) {
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.printf("\"%2s\" ", string);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
