package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IntegerToRoman12Test {

    private IntegerToRoman12 integerToRoman12;

    @BeforeEach
    public void init() {
        integerToRoman12 = new IntegerToRoman12();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testIntegerToRomanTransform(IntegerToRoman12Data testData) {
        String actual = integerToRoman12.intToRoman(testData.input);
        assertEquals(testData.output, actual);
    }

    public static List<IntegerToRoman12Data> testData() {
        return Arrays.asList(
                new IntegerToRoman12Data(3, "III"),
                new IntegerToRoman12Data(4, "IV"),
                new IntegerToRoman12Data(9, "IX"),
                new IntegerToRoman12Data(58, "LVIII"),
                new IntegerToRoman12Data(1994, "MCMXCIV"),
                new IntegerToRoman12Data(61, "LXI")
        );
    }

    @AllArgsConstructor
    @Getter
    static class IntegerToRoman12Data {
        int input;
        String output;
    }

}