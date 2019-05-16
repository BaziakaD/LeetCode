package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseInteger7Test {

    private ReverseInteger7 reverseInteger7;

    @BeforeEach
    public void init() {
        reverseInteger7 = new ReverseInteger7();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void fastReverseIntegerTest(ReverseInteger7Data testData) {
        long start = System.nanoTime();
        int reverse = reverseInteger7.reverse(testData.input);
        long end = System.nanoTime();
        System.out.println("Fast: " + (end - start) / 1000);
        assertEquals(testData.output, reverse);
    }

    public static List<ReverseInteger7Data> testData() {
        return asList
                (
                        new ReverseInteger7Data(123, 321),
                        new ReverseInteger7Data(-123, -321),
                        new ReverseInteger7Data(120, 21),
                        new ReverseInteger7Data(123456789, 987654321),
                        new ReverseInteger7Data(-123456789, -987654321),
                        new ReverseInteger7Data(Integer.MAX_VALUE, 0)
                );
    }

    @AllArgsConstructor
    @Getter
    static class ReverseInteger7Data {
        int input;
        int output;
    }
}