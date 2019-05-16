package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.epam.rd.javatester.TestMark;

import java.util.stream.Stream;

public class RomanToInteger13Test {

    private RomanToInteger13 romanToInteger;

    @BeforeEach
    public void init() {
        romanToInteger = new RomanToInteger13();
    }

    @ParameterizedTest
    @MethodSource("testData")
    @TestMark(5)
    public void testRomanToIntegerConvertation(RomanToInteger13Data data) {
        int actual = romanToInteger.romanToInt(data.input);
        Assertions.assertEquals(data.output, actual);
    }

    static Stream<RomanToInteger13Data> testData() {
        return Stream.of(
                new RomanToInteger13Data("IV", 5),
                new RomanToInteger13Data("III", 3)
        );
    }

    @AllArgsConstructor
    @Getter
    @ToString
    static class RomanToInteger13Data {
        String input;
        int output;
    }

}