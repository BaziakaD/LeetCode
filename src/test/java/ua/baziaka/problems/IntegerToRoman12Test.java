package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IntegerToRoman12Test {

    private IntegerToRoman12 integerToRoman12;
    private IntegerToRoman12Data testData;

    public IntegerToRoman12Test(IntegerToRoman12Data testData) {
        this.testData = testData;
    }

    @Before
    public void init() {
        integerToRoman12 = new IntegerToRoman12();
    }

    @Test
    public void testIntegerToRomanTransform() {
        String actual = integerToRoman12.intToRoman(testData.input);
        assertEquals(testData.output, actual);
    }

    @Parameterized.Parameters
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