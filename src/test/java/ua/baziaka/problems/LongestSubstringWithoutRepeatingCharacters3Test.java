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
public class LongestSubstringWithoutRepeatingCharacters3Test {

    private LongestSubstringWithoutRepeatingCharacters3 toTestAlg;
    private LongestSubstringWithoutRepeatingCharactersTestData testData;

    public LongestSubstringWithoutRepeatingCharacters3Test(LongestSubstringWithoutRepeatingCharactersTestData testData) {
        this.testData = testData;
    }

    @Before
    public void setUp() {
        toTestAlg = new LongestSubstringWithoutRepeatingCharacters3();
    }

    @Test
    public void testAlg() {
        int actual = toTestAlg.lengthOfLongestSubstring(testData.input);
        assertEquals(testData.length, actual);
    }

    @Parameters
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