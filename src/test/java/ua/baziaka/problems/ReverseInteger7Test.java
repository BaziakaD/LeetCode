package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class ReverseInteger7Test {

    private ReverseInteger7Data testData;
    private ReverseInteger7 reverseInteger7;

    public ReverseInteger7Test(ReverseInteger7Data testData) {
        this.testData = testData;
    }

    @Before
    public void init() {
        reverseInteger7 = new ReverseInteger7();
    }

    @Test
    public void reverseIntegerTest() {
        Assert.assertNotNull(reverseInteger7);
        long start = System.nanoTime();
        int reverse = reverseInteger7.reverse(testData.input);
        long end = System.nanoTime();
        System.out.println("Standard: " + (end - start) / 1000);
        Assert.assertEquals(testData.output, reverse);
    }

    @Test
    public void fastReverseIntegerTest() {
        long start = System.nanoTime();
        int reverse = reverseInteger7.reverse(testData.input);
        long end = System.nanoTime();
        System.out.println("Fast: " + (end - start) / 1000);
        Assert.assertEquals(testData.output, reverse);
    }

    @Parameters
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