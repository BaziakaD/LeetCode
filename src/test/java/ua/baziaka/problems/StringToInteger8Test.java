package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToInteger8Test {
    StringToInteger8 stringToInteger8 = new StringToInteger8();

    public static List<StringToInteger8TestData> testData() {
        return asList(
                new StringToInteger8TestData("", 0),
                new StringToInteger8TestData(" ", 0),
                new StringToInteger8TestData("   ", 0),
                new StringToInteger8TestData("a", 0),
                new StringToInteger8TestData("z", 0),
                new StringToInteger8TestData(".", 0),
                new StringToInteger8TestData("+", 0),
                new StringToInteger8TestData("-", 0),
                new StringToInteger8TestData("   +", 0),
                new StringToInteger8TestData("   -", 0),
                new StringToInteger8TestData("42", 42),
                new StringToInteger8TestData("+42", 42),
                new StringToInteger8TestData("   42", 42),
                new StringToInteger8TestData("   +42", 42),
                new StringToInteger8TestData("   ++42", 0),
                new StringToInteger8TestData("   -42", -42),
                new StringToInteger8TestData("-42", -42),
                new StringToInteger8TestData("-91283472332", -2147483648),
                new StringToInteger8TestData("91283472332", 2147483647),
                new StringToInteger8TestData("-2147483648", -2147483648),
                new StringToInteger8TestData("2147483648", 2147483647),
                new StringToInteger8TestData("3.14159", 3),
                new StringToInteger8TestData("0-42a1234", 0),
                new StringToInteger8TestData("   +0 123", 0),
                new StringToInteger8TestData("2147483646", 2147483646),
                new StringToInteger8TestData("  +  413", 0)
        );
    }

    @MethodSource("testData")
    @ParameterizedTest
    void stringToInteger8Test(StringToInteger8TestData testData) {
        int actual = stringToInteger8.myAtoi(testData.input);
        assertEquals(testData.result, actual);
    }

    @AllArgsConstructor
    static class StringToInteger8TestData {
        String input;
        int result;
    }

}