package com.alviel.stream;

/**
 * @author Oscar Alvarez
 * @since 9/23/16
 */
public class StringCalculator {
    private final String stream;

    public StringCalculator(String input) {
        this.stream = input;
    }

    public Long calculate() {
        Long total = 0l;
        if (streamIsNumber(stream)) {
            total = Long.valueOf(stream);
        } else if (hasMoreThanOneNumber()) {
            String[] numbers = stream.split(",");
            for (String number : numbers) {
                total += Long.valueOf(number);
            }
        }
        return total;
    }

    private boolean streamIsNumber(String stream) {
        boolean result = false;
        try {
            Long.valueOf(stream);
            result = true;
        } catch (RuntimeException e) {
            System.out.println("NaN");
        }
        return result;
    }

    private boolean hasMoreThanOneNumber() {
        String[] numbers = stream.split(",");
        for (String number : numbers) {
            if (!streamIsNumber(number)) {
                return false;
            }
        }
        return numbers.length > 0;
    }

    public String reverse() {
        String result = "";
        if (streamIsNotNull()) {
            if (hasVariousCharacters()) {
                result = iterateBackwardStream(result);
            } else {
                result = stream;
            }
        }
        return result;
    }

    private String iterateBackwardStream(String result) {
        for (int i = stream.length() - 1; i >= 0; i--) {
            result += stream.charAt(i);
        }
        return result;
    }

    private boolean hasVariousCharacters() {
        return stream.length() > 1;
    }

    private boolean streamIsNotNull() {
        return stream != null;
    }
}
