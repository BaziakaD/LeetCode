package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagConversion6Test {

    private ZigZagConversion6 toTestAlg;

    @BeforeEach
    public void setUp() throws Exception {
        toTestAlg = new ZigZagConversion6();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testZigZagConversion(ZigZagConversionTestData testData) {
        String actual = toTestAlg.convert(testData.input, testData.numRows);
        assertEquals(testData.output, actual);
    }

    public static List<ZigZagConversionTestData> testData() {
        return asList(
                new ZigZagConversionTestData("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                new ZigZagConversionTestData("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                new ZigZagConversionTestData("12345678901234567", 5, "19728063715462453"),
                new ZigZagConversionTestData("12345678901234567", 1, "12345678901234567"),
                new ZigZagConversionTestData("12345678901234567", 0, ""),
                new ZigZagConversionTestData("", 5, "")
        );
    }

    @AllArgsConstructor
    static class ZigZagConversionTestData {
        String input;
        int numRows;
        String output;
    }
}