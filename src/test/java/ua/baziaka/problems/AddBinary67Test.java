package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class AddBinary67Test {

    private AddBinary67 addBinary = new AddBinary67();

    @ParameterizedTest
    @MethodSource("testData")
    void testAddBinary(AddBinary67TestData testData) {
        var result = addBinary.addBinary(testData.a, testData.b);
        assertEquals(testData.result, result);
    }


    public static List<AddBinary67TestData> testData() {
        return asList(
                new AddBinary67TestData("0", "1", "1"),
                new AddBinary67TestData("1", "0", "1"),
                new AddBinary67TestData("10", "01", "11"),
                new AddBinary67TestData("11", "01", "100"),
                new AddBinary67TestData("11", "1", "100"),
                new AddBinary67TestData("1010", "1011", "10101"),
                new AddBinary67TestData("111110", "101", "1000011"),
                new AddBinary67TestData("1111", "1111", "11110")
        );
    }


    @AllArgsConstructor
    @Getter
    static class AddBinary67TestData {
        String a, b, result;
    }

}