package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class MultiplyStrings43Test {

    MultiplyStrings43 multiplyStrings = new MultiplyStrings43();

    @ParameterizedTest
    @MethodSource("testData")
    public void multiplyStringsTest(MultiplyStrings43TestData testData) {
        String actual = multiplyStrings.multiply(testData.a, testData.b);
        assertEquals(testData.res, actual);
    }


    public static List<MultiplyStrings43TestData> testData() {
        return asList(
                new MultiplyStrings43TestData("2", "3", "6"),
                new MultiplyStrings43TestData("9", "9", "81"),
                new MultiplyStrings43TestData("9", "99", "891"),
                new MultiplyStrings43TestData("54", "641", "34614"),
                new MultiplyStrings43TestData("123", "456", "56088"),
                new MultiplyStrings43TestData("1234", "657", "810738"),
                new MultiplyStrings43TestData("123456789", "987654321", "121932631112635269")
        );
    }


    @AllArgsConstructor
    @Getter
    static class MultiplyStrings43TestData {
        String a, b, res;
    }
}