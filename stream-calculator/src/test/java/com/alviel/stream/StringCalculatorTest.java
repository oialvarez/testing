package com.alviel.stream;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Oscar Alvarez
 * @since 9/23/16
 */
public class StringCalculatorTest {

    private void checkCalculateResult(StringCalculator calculator, Long expected) {
        Assert.assertThat(calculator.calculate(), Is.is(expected));
    }

    private void checkReverseResult(StringCalculator calculator, String expected) {
        Assert.assertThat(calculator.reverse(), Is.is(expected));
    }

    @Test
    public void testEmptyString() throws Exception {
        StringCalculator stringCalculator = new StringCalculator("");
        checkCalculateResult(stringCalculator, 0l);
    }

    @Test
    public void testOneNumber() throws Exception {
        StringCalculator stringCalculator = new StringCalculator("1");
        checkCalculateResult(stringCalculator, 1l);
    }

    @Test
    public void testNonNumber() throws Exception {
        StringCalculator stringCalculator = new StringCalculator("@");
        checkCalculateResult(stringCalculator, 0l);
    }

    @Test
    public void testTwoNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator("1,1");
        checkCalculateResult(stringCalculator, 2l);
    }

    @Test
    public void testThreeNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator("1,2,3");
        checkCalculateResult(stringCalculator, 6l);
    }

    @Test
    public void testReverseEmptyString() throws Exception {
        StringCalculator stringCalculator = new StringCalculator("");
        checkReverseResult(stringCalculator, "");
    }

    @Test
    public void testReverseNullString() throws Exception {
        checkReverseResult(new StringCalculator(null), "");
    }

    @Test
    public void testReverseOneNumber() throws Exception {
        checkReverseResult(new StringCalculator("1"), "1");
    }

    @Test
    public void testReverseTwoNumbers() throws Exception {
        checkReverseResult(new StringCalculator("1,2"), "2,1");
    }

    @Test
    public void testReverseThreeNumbers() throws Exception {
        checkReverseResult(new StringCalculator("1,2,3"), "3,2,1");
    }
}
