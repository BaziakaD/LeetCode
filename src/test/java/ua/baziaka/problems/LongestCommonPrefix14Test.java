package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefix14Test {

    LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();

    @MethodSource("testData")
    @ParameterizedTest
    void testLongestCommonPrefix14(LongestCommonPrefix14TestData testData) {
        String actualPrefix = longestCommonPrefix14.longestCommonPrefix(testData.strings);
        assertEquals(testData.expectedPrefix, actualPrefix);
    }

    public static List<LongestCommonPrefix14TestData> testData() {
        return asList(
//                new LongestCommonPrefix14TestData(new String[]{"car"}, "car"),
//                new LongestCommonPrefix14TestData(new String[]{"car", "cargo"}, "car"),
                new LongestCommonPrefix14TestData(new String[]{"ab", "a"}, "a"),
                new LongestCommonPrefix14TestData(new String[]{"flower","flow","flight"}, "fl"),
                new LongestCommonPrefix14TestData(new String[]{"dog","racecar","car"}, "")
        );
    }

    @AllArgsConstructor
    static class LongestCommonPrefix14TestData {
        String[] strings;
        String expectedPrefix;
    }

}