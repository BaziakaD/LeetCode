package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters3Test {

    private LongestSubstringWithoutRepeatingCharacters3 toTestAlg;

    @BeforeEach
    public void setUp() {
        toTestAlg = new LongestSubstringWithoutRepeatingCharacters3();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testAlg(LongestSubstringWithoutRepeatingCharactersTestData testData) {
        int actual = toTestAlg.lengthOfLongestSubstring(testData.input);
        assertEquals(testData.length, actual);
    }

    public static List<LongestSubstringWithoutRepeatingCharactersTestData> testData() {
        return asList(
                new LongestSubstringWithoutRepeatingCharactersTestData("abcabcbb", 3),
                new LongestSubstringWithoutRepeatingCharactersTestData("abcadcbb", 4),
                new LongestSubstringWithoutRepeatingCharactersTestData("bbbb", 1),
                new LongestSubstringWithoutRepeatingCharactersTestData("pwwkew", 3),
                new LongestSubstringWithoutRepeatingCharactersTestData(" ", 1),
                new LongestSubstringWithoutRepeatingCharactersTestData("dvdf", 3),
                new LongestSubstringWithoutRepeatingCharactersTestData("ckilbkd", 5),
                new LongestSubstringWithoutRepeatingCharactersTestData("ynyo", 3)
        );
    }

    @AllArgsConstructor
    static class LongestSubstringWithoutRepeatingCharactersTestData {
        String input;
        int length;
    }
}