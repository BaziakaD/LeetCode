package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class RomanToInteger13Test {

    private RomanToInteger13 romanToInteger;
    private RomanToInteger13Data testData;

    public RomanToInteger13Test(RomanToInteger13Data testData) {
        this.testData = testData;
    }

    @Before
    public void init() {
        romanToInteger = new RomanToInteger13();
    }

    @Test
    public void testRomanToIntegerConvertation() {
        int actual = romanToInteger.romanToInt(testData.input);
        Assert.assertEquals(testData.output, actual);
    }

    @Parameters
    public static List<RomanToInteger13Data> testData() {
        return Arrays.asList(
                new RomanToInteger13Data("III", 3),
                new RomanToInteger13Data("IV", 4),
                new RomanToInteger13Data("IX", 9),
                new RomanToInteger13Data("LVIII", 58),
                new RomanToInteger13Data("MCMXCIV", 1994)
        );
    }

    @AllArgsConstructor
    @Getter
    static class RomanToInteger13Data {
        String input;
        int output;
    }

}