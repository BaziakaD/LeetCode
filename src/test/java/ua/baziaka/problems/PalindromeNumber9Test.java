package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumber9Test {

    PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();


    @MethodSource("testData")
    @ParameterizedTest
    void testPalindromeNumber(PalindromeNumber9TestData testData) {
        boolean actual = palindromeNumber9.isPalindrome(testData.x);
        assertEquals(testData.result, actual);
    }

    public static List<PalindromeNumber9TestData> testData() {

        return asList(
                new PalindromeNumber9TestData(1, true),
                new PalindromeNumber9TestData(22, true),
                new PalindromeNumber9TestData(121, true),
                new PalindromeNumber9TestData(-121, false),
                new PalindromeNumber9TestData(Integer.MAX_VALUE-1, false)
        );
    }


    @AllArgsConstructor
    @Getter
    static class PalindromeNumber9TestData {
        int x;
        boolean result;
    }

}