package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class PlusOne66Test {

    PlusOne66 plusOne66 = new PlusOne66();

    @ParameterizedTest
    @MethodSource("testData")
    public void lusOne66Test(PlusOne66TestData testData) {
        int[] output = plusOne66.plusOne(testData.getInput());
        assertArrayEquals(testData.getOutput(), output);
    }

    public static List<PlusOne66TestData> testData() {
        return asList(
                new PlusOne66TestData(new int[]{1,2,3}, new int[]{1,2,4}),
                new PlusOne66TestData(new int[]{9}, new int[]{1,0}),
                new PlusOne66TestData(new int[]{9,9}, new int[]{1,0,0}),
                new PlusOne66TestData(new int[]{9,9,9}, new int[]{1,0,0,0}),
                new PlusOne66TestData(new int[]{9,9,8}, new int[]{9,9,9}),
                new PlusOne66TestData(new int[]{0}, new int[]{1}),
                new PlusOne66TestData(new int[]{8,9,9,9}, new int[]{9,0,0,0}),
                new PlusOne66TestData(new int[]{9,8,9}, new int[]{9,9,0})
        );
    }

    @AllArgsConstructor
    @Getter
    static class PlusOne66TestData {
        int[] input;
        int[] output;
    }

}