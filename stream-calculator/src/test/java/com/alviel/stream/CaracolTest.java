package com.alviel.stream;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author Oscar Alvarez
 * @since 9/23/16
 */
public class CaracolTest {
    @Mock
    private StringCalculator stringCalculator;

    private void checkReverseMatrix(Caracol caracol, String[][] matrix, String mocked) {
        caracol.setStringCalculator(stringCalculator);
        Mockito.when(stringCalculator.reverse()).thenReturn(mocked);
        String[][] result = caracol.reverseMatrix();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println("result[i][j] = \"" + result[i][j] + "\", matrix[i][j] = \"" + matrix[i][j] + "\"");
                Assert.assertThat(result[i][j], Is.is(matrix[i][j]));
            }
        }
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNullStream() throws Exception {
        checkReverseMatrix(new Caracol(null), new String[][]{{""}}, "");
    }

    @Test
    public void testEmptyStream() throws Exception {
        checkReverseMatrix(new Caracol(""), new String[][]{{""}}, "");
    }

    @Test
    public void testOneElement() throws Exception {
        String stream = "1";
        checkReverseMatrix(new Caracol(stream), new String[][]{{stream}}, stream);
    }

    @Test
    public void testTwoElements() throws Exception {
        String stream = "1,2";
        String[][] expected = new String[][]{{"", ""}, {"2", "1"}};
        String mocked = "2,1";

        checkReverseMatrix(new Caracol(stream), expected, mocked);

    }

    @Test
    public void testThreeElements() throws Exception {
        String stream = "1,2,3";
        String[][] expected = new String[][]{{"", "1"}, {"3", "2"}};
        String mocked = "3,2,1";

        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testFourElements() throws Exception {
        String stream = "1,2,3,4";
        String[][] expected = new String[][]{{"1", "2"}, {"4", "3"}};
        String mocked = "4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testFiveElements() throws Exception {
        String stream = "1,2,3,4,5";
        String[][] expected = new String[][]{
            {"1", "2", "3"},
            {"", "5", "4"},
            {"", "", ""}
        };
        String mocked = "5,4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testSixElements() throws Exception {
        String stream = "1,2,3,4,5,6";
        String[][] expected = new String[][]{
            {"2", "3", "4"},
            {"1", "6", "5"},
            {"", "", ""}
        };
        String mocked = "6,5,4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testSevenElements() throws Exception {
        String stream = "1,2,3,4,5,6,7";
        String[][] expected = new String[][]{
            {"3", "4", "5"},
            {"2", "7", "6"},
            {"1", "", ""}
        };
        String mocked = "7,6,5,4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testEightElements() throws Exception {
        String stream = "1,2,3,4,5,6,7,8";
        String[][] expected = new String[][]{
            {"4", "5", "6"},
            {"3", "8", "7"},
            {"2", "1", ""}
        };
        String mocked = "8,7,6,5,4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testNineElements() throws Exception {
        String stream = "1,2,3,4,5,6,7,8,9";
        String[][] expected = new String[][]{
            {"5", "6", "7"},
            {"4", "9", "8"},
            {"3", "2", "1"}
        };
        String mocked = "9,8,7,6,5,4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testTwentyFiveElements() throws Exception {
        String stream = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25";
        String[][] expected = new String[][]{
            {"9", "10", "11", "12", "13"},
            {"8", "21", "22", "23", "14"},
            {"7", "20", "25", "24", "15"},
            {"6", "19", "18", "17", "16"},
            {"5", "4", "3", "2", "1"},
            };
        String mocked = "25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1";
        checkReverseMatrix(new Caracol(stream), expected, mocked);
    }

    @Test
    public void testany() throws Exception {
        for (int i = 1; i < 100; i++) {
            String stream = "";
            for (int j = 1; j < i + 1; j++) {
                stream += j + ",";
            }
            stream = stream.substring(0, stream.length() - 1);
            Caracol caracol = new Caracol(stream);
            caracol.setStringCalculator(new StringCalculator(stream));
            String[][] strings = caracol.reverseMatrix();
            caracol.print(strings);
        }
    }
}
