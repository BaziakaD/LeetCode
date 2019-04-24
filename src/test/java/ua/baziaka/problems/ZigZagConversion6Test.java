package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ZigZagConversion6Test {

    private ZigZagConversion6 toTestAlg;
    private ZigZagConversionTestData testData;

    public ZigZagConversion6Test(ZigZagConversionTestData testData) {
        this.testData = testData;
    }

    @Before
    public void setUp() throws Exception {
        toTestAlg = new ZigZagConversion6();
    }

    @Test
    public void testZigZagConversion() {
        String actual = toTestAlg.convert(testData.input, testData.numRows);
        assertEquals(testData.output, actual);
    }

    @Parameters
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